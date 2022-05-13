package com.mgt.api.resources;

import java.net.URI;

import javax.validation.Valid;

import com.mgt.api.dto.CardDTO;
import com.mgt.api.services.CardService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping(value = "/v1/cards")
public class CardResource {

  @Autowired
  private CardService service;

  @GetMapping
  public ResponseEntity<Page<CardDTO>> findAll(@RequestParam(value = "page", defaultValue = "0") Integer page,
      @RequestParam(value = "linesPerPage", defaultValue = "20") Integer linesPerPage,
      @RequestParam(value = "direction", defaultValue = "ASC") String direction,
      @RequestParam(value = "orderBy", defaultValue = "name") String orderBy) {

    PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);

    Page<CardDTO> listCards = service.findAllPaged(pageRequest);

    return ResponseEntity.ok().body(listCards);
  }

  @GetMapping(value = "/{id}")
  public ResponseEntity<CardDTO> findById(@PathVariable Long id) {
    CardDTO cardDTO = service.findById(id);
    return ResponseEntity.ok().body(cardDTO);
  }

  @PostMapping
  public ResponseEntity<CardDTO> insert(@Valid @RequestBody CardDTO cardDto) {
    cardDto = service.insert(cardDto);
    URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path(("/{id}")).buildAndExpand(cardDto.getId()).toUri();

    return ResponseEntity.created(uri).body(cardDto);
  }

  @PutMapping(value = "/{id}")
  public ResponseEntity<CardDTO> update(@Valid @PathVariable Long id, @RequestBody CardDTO cardDto) {
    cardDto = service.update(id, cardDto);
    cardDto.setPrice(cardDto.getPrice());
    cardDto.setQuantity(cardDto.getQuantity());
    return ResponseEntity.ok().body(cardDto);
  }

  @DeleteMapping(value = "/{id}")
  public ResponseEntity<Void> update(@Valid @PathVariable Long id) {
    service.delete(id);
    return ResponseEntity.noContent().build();
  }
}