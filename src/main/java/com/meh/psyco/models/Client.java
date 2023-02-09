package com.meh.psyco.models;

import com.meh.psyco.dto.ClientDTO;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "clients")
@NamedQueries({
        @NamedQuery(name = "findByCdid", query = "select c from Client c where upper(c.cdid) = upper(:cdId)")
})
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String cdid;

    private String name;

    private String lastName;

    private String address;

    private String phone;

    private String email;

    @OneToMany(mappedBy = "client")
    private Set<Booking> bookings;

    public static Client fromDTO(ClientDTO clientDTO) {
        Client client = new Client();
        client.setName(clientDTO.getName());
        client.setLastName(clientDTO.getLastName());
        client.setAddress(clientDTO.getAddress());
        client.setCdid(clientDTO.getCdid());
        client.setEmail(clientDTO.getEmail());
        client.setPhone(clientDTO.getPhone());

        return client;
    }

    public void updateFromDTO(ClientDTO clientDTO) {
        setName(clientDTO.getName());
        setLastName(clientDTO.getLastName());
        setAddress(clientDTO.getAddress());
        setCdid(clientDTO.getCdid());
        setEmail(clientDTO.getEmail());
        setPhone(clientDTO.getPhone());
    }
}
