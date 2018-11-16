package net.dallascricket.paidUmpiring.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.dallascricket.paidUmpiring.jpa.model.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, Integer> {

}
