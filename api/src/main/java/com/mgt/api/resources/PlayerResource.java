package com.mgt.api.resources;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import com.mgt.api.dto.PlayerDTO;
import com.mgt.api.services.PlayerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping(value = "/v1/players")
public class PlayerResource {

  @Autowired
  public PlayerService service;

  @GetMapping
  public ResponseEntity<List<PlayerDTO>> findAll() {
    List<PlayerDTO> players = service.findAll();
    return ResponseEntity.ok().body(players);
  }

  @GetMapping(value = "/{id}")
  public ResponseEntity<PlayerDTO> findById(@PathVariable Long id) {
    PlayerDTO cardDTO = service.findById(id);
    return ResponseEntity.ok().body(cardDTO);
  }

  @PostMapping
  public ResponseEntity<PlayerDTO> insert(@Valid @RequestBody PlayerDTO playerDto) {
    playerDto = service.insert(playerDto);
    URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path(("/{id}")).buildAndExpand(playerDto.getId())
        .toUri();

    return ResponseEntity.created(uri).body(playerDto);
  }

}
