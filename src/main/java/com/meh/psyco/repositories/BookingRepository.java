package com.meh.psyco.repositories;

import com.meh.psyco.models.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface BookingRepository extends JpaRepository<Booking, Long> {

    @Query("select r from Booking r where r.inDate =:inDate and r.outDate =:outDate")
    List<Booking> find(@Param("inDate") Date inDate, @Param("outDate") Date outDate);
}
