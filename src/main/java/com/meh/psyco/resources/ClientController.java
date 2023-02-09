package com.meh.psyco.resources;

import com.meh.psyco.dto.ClientDTO;
import com.meh.psyco.models.Client;
import com.meh.psyco.services.ClientService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/clients")
public class ClientController {

    private ClientService clientService;

    public ClientController(
            ClientService clientService
    ) {
        this.clientService = clientService;
    }

    @GetMapping
    public ResponseEntity<List<Client>> getClients() {
        List<Client> clients = clientService.getAllClients();
        return ResponseEntity.ok(clients);
    }

    @PostMapping
    public ResponseEntity<Client> createClient(@RequestBody ClientDTO clientDTO) {
        return ResponseEntity.ok(clientService.newClient(Client.fromDTO(clientDTO)));
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<Client> updateClient(@PathVariable("id") Long id, @RequestBody ClientDTO clientDTO) {
        Optional<Client> clientExist = clientService.getClient(id);
        if (clientExist.isPresent()) {
            Client client = clientExist.get();
            client.updateFromDTO(clientDTO);

            return ResponseEntity.ok(clientService.updateClient(client));
        }

        return ResponseEntity.notFound().build();
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> deleteClient(@PathVariable("id") Long id) {
        Optional<Client> clientExist = clientService.getClient(id);
        if (clientExist.isPresent()) {
            clientService.deleteClient(clientExist.get());
            return ResponseEntity.ok().build();
        }

        return ResponseEntity.notFound().build();
    }
}
