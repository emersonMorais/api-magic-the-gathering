package com.mgt.api.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.mgt.api.entities.Card;
import com.mgt.api.entities.Deck;

public class CardDTO implements Serializable {
  private Long id;

  @Size(max = 20)
  @NotBlank(message = "Campo Obrigatório")
  private String name;

  @Size(max = 10)
  @NotBlank(message = "Campo Obrigatório")
  private String edition;

  @Size(max = 10)
  @NotBlank(message = "Campo Obrigatório")
  private String language;

  private Boolean foil;

  @Digits(integer = 6, fraction = 2)
  @NotNull
  private Double price;

  @Digits(integer = 3, fraction = 0)
  @NotNull
  private Integer quantity;

  private List<DeckDTO> decks = new ArrayList<>();

  public CardDTO() {
  }

  public CardDTO(Long id, String name, String edition, String language, Boolean foil, Double price, Integer quantity) {

    this.id = id;

    this.name = name;

    this.edition = edition;

    this.language = language;

    this.foil = foil;

    this.price = price;

    this.quantity = quantity;
  }

  public CardDTO(Card entity, Set<Deck> decks) {
    this(entity);
    decks.forEach(deck -> this.decks.add(new DeckDTO(deck)));
  }

  public CardDTO(Card entity) {
    this.id = entity.getId();

    this.name = entity.getName();

    this.edition = entity.getEdition();

    this.language = entity.getLanguage();

    this.foil = entity.getFoil();

    this.price = entity.getPrice();

    this.quantity = entity.getQuantity();
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

  public String getEdition() {
    return edition;
  }

  public void setEdition(String edition) {
    this.edition = edition;
  }

  public String getLanguage() {
    return language;
  }

  public void setLanguage(String language) {
    this.language = language;
  }

  public Boolean getFoil() {
    return foil;
  }

  public void setFoil(Boolean foil) {
    this.foil = foil;
  }

  public Double getPrice() {
    return price;
  }

  public void setPrice(Double price) {
    this.price = price;
  }

  public Integer getQuantity() {
    return quantity;
  }

  public void setQuantity(Integer quantity) {
    this.quantity = quantity;
  }

  public List<DeckDTO> getDecks() {
    return decks;
  }

  public void setDecks(List<DeckDTO> decks) {
    this.decks = decks;
  }

}
