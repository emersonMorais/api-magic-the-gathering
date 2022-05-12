package com.mgt.api.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "cards")
public class Card implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String name;

  private String edition;

  private String language;

  private Boolean foil;

  private Double price;

  private Integer quantity;

  @ManyToMany
  @JoinTable(name = "tb_card_deck", joinColumns = @JoinColumn(name = "card_id"), inverseJoinColumns = @JoinColumn(name = "deck_id"))
  Set<Deck> decks = new HashSet<>();

  public Card() {
  }

  public Card(Long id, String name, String edition, String language, Boolean foil, Double price, Integer quantity) {

    this.id = id;

    this.name = name;

    this.edition = edition;

    this.language = language;

    this.foil = foil;

    this.price = price;

    this.quantity = quantity;

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

  public Set<Deck> getDecks() {
    return decks;
  }

  public void setDecks(Set<Deck> decks) {
    this.decks = decks;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((id == null) ? 0 : id.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Card other = (Card) obj;
    if (id == null) {
      if (other.id != null)
        return false;
    } else if (!id.equals(other.id))
      return false;
    return true;
  }

}
