package com.mgt.api.services;

import java.util.Optional;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;

import com.mgt.api.dto.CardDTO;
import com.mgt.api.entities.Card;
import com.mgt.api.repositories.CardRepository;
import com.teste.api.mgt.services.exceptions.DatabaseException;
import com.teste.api.mgt.services.exceptions.ResourceNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class CardService {

  @Autowired
  private CardRepository repository;


  @Transactional
  public Page<CardDTO> findAllPaged(PageRequest pageRequest) {
    Page<Card> listCards = repository.findAll(pageRequest);
    return listCards.map(card -> new CardDTO(card, card.getDecks()));
  }

  @Transactional
  public CardDTO findById(Long id) {
    Optional<Card> obj = repository.findById(id);
    Card entity = obj.orElseThrow(() -> new ResourceNotFoundException("Card Inexistente"));
    return new CardDTO(entity);
  }

  @Transactional
  public CardDTO insert(CardDTO cardDTO) {
    Card entity = new Card();
    entity.setName(cardDTO.getName());
    entity.setEdition(cardDTO.getEdition());
    entity.setLanguage(cardDTO.getLanguage());
    entity.setFoil(cardDTO.getFoil());
    entity.setPrice(cardDTO.getPrice());
    entity.setQuantity(cardDTO.getQuantity());

    entity = repository.save(entity);
    return new CardDTO(entity);
  }

  @Transactional
  public CardDTO update(Long id, CardDTO cardDto) {

    try {
      Card entity = repository.getById(id);
      entity.setPrice(cardDto.getPrice());
      entity.setQuantity(cardDto.getQuantity());
      entity = repository.save(entity);
      return new CardDTO(entity);
      
    } catch (EntityNotFoundException e) {
      throw new ResourceNotFoundException("Card Inexistente");
    }

  }

  public void delete(Long id) {
    try {
      repository.deleteById(id);
    }
    catch(EmptyResultDataAccessException e){
      throw new ResourceNotFoundException("Card Inexistente");
    }
    catch (DataIntegrityViolationException e){
      throw new DatabaseException("Não é possível Deletar essa instância");
    }
    
   
  }

}
