package com.meh.psyco.services;

import com.meh.psyco.models.Client;
import com.meh.psyco.repositories.ClientRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class ClientService {

    private final ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

    public Optional<Client> getClient(Long id) {
        return clientRepository.findById(id);
    }

    @Transactional
    public Client newClient(Client client) {
        return clientRepository.save(client);
    }

    @Transactional
    public Client updateClient(Client client) {
        return clientRepository.save(client);
    }

    @Transactional
    public void deleteClient(Client client) {
        clientRepository.delete(client);
    }

    public void findByCdIdentification(String cdId) {
        clientRepository.findByCdid(cdId);
    }
}
