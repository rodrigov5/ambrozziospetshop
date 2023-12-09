package com.petshop.ambrozziospetshop.api.controller;


import com.petshop.ambrozziospetshop.domain.dtos.ClientDTO;
import com.petshop.ambrozziospetshop.domain.services.IClientService;
import com.petshop.ambrozziospetshop.domain.utils.singleton.LoggerUtil;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("client")
public class ClientController {
    private final IClientService clientService;

    public ClientController(IClientService clientService) {
        this.clientService = clientService;
    }

    @PostMapping
    public ResponseEntity<?> saveClient(@RequestBody @Valid ClientDTO clientDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(clientService.create(clientDTO));
    }

    @GetMapping
    public ResponseEntity<?> findAll() {
        LoggerUtil log = LoggerUtil.getInstance();

        log.debug("test DEBUG");
        log.warn("test WARN");
        log.error("test ERROR");

        return ResponseEntity.ok(clientService);
    }
}
