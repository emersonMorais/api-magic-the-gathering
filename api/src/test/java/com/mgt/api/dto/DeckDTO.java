package com.mgt.api.dto;


import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.mgt.api.entities.Card;
import com.mgt.api.entities.Deck;
import com.mgt.api.entities.Player;

public class DeckDTO implements Serializable {
  private Long id;


  @Size(max = 20)
  @NotBlank(message="Campo Obrigatório")
  private String name;

  private Long playerId;

  private Set<CardDTO> cards = new HashSet<>();

  public DeckDTO() {
  }

  public DeckDTO(Long id, String name, Long playerId) {
    this.id = id;
    this.name = name;
    this.playerId = playerId;
  }

  public DeckDTO(Long id, String name) {
    this.id = id;
    this.name = name;
  }

  public DeckDTO(Deck entity) {
    this.id = entity.getId();
    this.name = entity.getName();
    this.playerId = entity.getPlayer().getId();
  }

  public DeckDTO(Deck entity, Player player, Set<Card> cards) {
    this(entity);
    cards.forEach(card -> this.cards.add(new CardDTO(card))); 
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
  
  public Long getPlayerId() {
    return playerId;
  }

  public void setPlayerId(Long playerId) {
    this.playerId = playerId;
  }

  public Set<CardDTO> getCards() {
    return cards;
  }

  public void setCards(Set<CardDTO> cards) {
    this.cards = cards;
  }

}
