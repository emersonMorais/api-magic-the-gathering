package com.mgt.api.dto;


import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotBlank;

import com.mgt.api.entities.Player;

public class PlayerDTO {
  private Long id;
  
  @NotBlank(message="Campo Obrigatório")
  private String name;
  
  private List<DeckDTO> decks = new ArrayList<>();

  public PlayerDTO() {
  }

  public PlayerDTO(Long id, String name) {
    this.id = id;
    this.name = name;
  }

  public PlayerDTO(Player entity) {
    this.id = entity.getId();
    this.name = entity.getName();
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public List<DeckDTO> getDecks() {
    return decks;
  }

}
