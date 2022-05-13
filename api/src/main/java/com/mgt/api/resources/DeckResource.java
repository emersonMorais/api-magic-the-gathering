package com.mgt.api.resources;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import com.mgt.api.dto.DeckDTO;
import com.mgt.api.services.DeckService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping(value = "/v1/decks")
public class DeckResource {

  @Autowired
  public DeckService service;

  @GetMapping
  public ResponseEntity<List<DeckDTO>> findAll() {
    List<DeckDTO> decks = service.findAll();
    return ResponseEntity.ok().body(decks);
  }

  @GetMapping(value = "/{id}")
  public ResponseEntity<DeckDTO> findById(@PathVariable Long id) {
    DeckDTO cardDTO = service.findById(id);
    return ResponseEntity.ok().body(cardDTO);
  }

  @PostMapping
  public ResponseEntity<DeckDTO> insert(@Valid @RequestBody DeckDTO deckDto) {
    deckDto = service.insertDeck(deckDto);
    URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path(("/{id}")).buildAndExpand(deckDto.getId()).toUri();

    return ResponseEntity.created(uri).body(deckDto);
  }

  @PutMapping(value = "/{id}")
  public ResponseEntity<DeckDTO> update(@Valid @PathVariable Long id, @RequestBody DeckDTO deckDto) {
    deckDto = service.update(id, deckDto);
    return ResponseEntity.ok().body(deckDto);
  }
}
