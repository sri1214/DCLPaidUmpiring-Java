package net.dallascricket.paidUmpiring.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.dallascricket.paidUmpiring.jpa.model.Game;

public interface GameRepository extends JpaRepository<Game, Integer> {

}
