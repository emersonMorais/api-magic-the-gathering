package com.mgt.api.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import com.mgt.api.dto.PlayerDTO;
import com.mgt.api.entities.Player;
import com.mgt.api.repositories.PlayerRepository;
import com.teste.api.mgt.services.exceptions.ResourceNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlayerService {

  @Autowired
  public PlayerRepository repository;
  
  @Transactional
  public List<PlayerDTO> findAll() {
    List<Player> players = repository.findAll();
    
    List<PlayerDTO> playersDto = players.stream().map(player -> new PlayerDTO(player)).collect(Collectors.toList()); 

    return playersDto;
  }

  @Transactional
  public PlayerDTO findById(Long id) {
    Optional<Player> obj = repository.findById(id);
    Player entity = obj.orElseThrow(() -> new ResourceNotFoundException("Card Inexistente"));
    return new PlayerDTO(entity);
  }
  
  @Transactional
  public PlayerDTO insert(PlayerDTO playerDTO){
    Player entity =  new Player();
    entity.setName(playerDTO.getName());
    entity = repository.save(entity);
    return new PlayerDTO(entity);
  }

}
