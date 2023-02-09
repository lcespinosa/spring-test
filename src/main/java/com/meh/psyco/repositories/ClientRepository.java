package com.meh.psyco.repositories;

import com.meh.psyco.models.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClientRepository extends JpaRepository<Client, Long> {

    public List<Client> findByLastName(String lastName);
    public Client findByCdid(String cdId);
}
