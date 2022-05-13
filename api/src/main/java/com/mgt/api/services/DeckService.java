package com.mgt.api.services;


import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import com.mgt.api.dto.DeckDTO;
import com.mgt.api.entities.Deck;
import com.mgt.api.entities.Player;
import com.mgt.api.repositories.DeckRepository;
import com.teste.api.mgt.services.exceptions.ResourceNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class DeckService {
  
  @Autowired
  private DeckRepository repository;

  //criar métodos de busca no banco
  @Transactional
  public DeckDTO insertDeck(DeckDTO deckDto) {
    Deck entity = new Deck();
    entity.setName(deckDto.getName());

    Player player = new Player();
    player.setId(deckDto.getPlayerId());
    entity.setPlayer(player);

    entity = repository.save(entity);
    return new DeckDTO(entity);
  }
  
  @Transactional
  public List<DeckDTO> findAll() {
    List<Deck> decks = repository.findAll();
    List<DeckDTO> listDecksDto = decks.stream().map(deck -> new DeckDTO(deck, deck.getPlayer(), deck.getCards())).collect(Collectors.toList());
    
    return listDecksDto;
  }

  @Transactional
  public DeckDTO findById(Long id) {
      Optional<Deck> obj = repository.findById(id);
      Deck entity = obj.orElseThrow(() -> new ResourceNotFoundException("Card Inexistente"));
      return new DeckDTO(entity,entity.getPlayer(),entity.getCards());
  }

  @Transactional
  public DeckDTO update(Long id, DeckDTO deckDto) {
    return null;
  }
 
}

