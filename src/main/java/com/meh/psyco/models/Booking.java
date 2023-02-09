package com.meh.psyco.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@Entity
@Table(name = "bookings")
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Temporal(TemporalType.DATE)
    private Date inDate;

    @Temporal(TemporalType.DATE)
    private Date outDate;

    private int peopleCount;

    private String description;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;
}
