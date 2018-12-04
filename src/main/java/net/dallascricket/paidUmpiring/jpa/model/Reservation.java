package net.dallascricket.paidUmpiring.jpa.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import net.dallascricket.paidUmpiring.Request.ReservationReq;
@Entity
public class Reservation {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)	
	private Integer id;
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name="game_id")	
	private Game game;
	
	@ManyToOne
	@JoinColumn(name="umpire_id")	
	private Umpire umpire;
	
	private LocalDateTime date;
	private boolean leather;
	private String requestingTeam;
	

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	public Game getGame() {
		return game;
	}
	public void setGame(Game game) {
		this.game = game;
	}

	public Umpire getUmpire() {
		return umpire;
	}
	public void setUmpire(Umpire umpire) {
		this.umpire = umpire;
	}

	public LocalDateTime getDate() {
		return date;
	}
	public void setDate(LocalDateTime date) {
		this.date = date;
	}
	public boolean isLeather() {
		return leather;
	}
	public void setLeather(boolean leather) {
		this.leather = leather;
	}
	
	public String getRequestingTeam() {
		return requestingTeam;
	}
	public void setRequestingTeam(String requestingTeam) {
		this.requestingTeam = requestingTeam;
	}



	public static class ReservationBuilder {
	        private Reservation reservation = new Reservation();

	        public ReservationBuilder(ReservationReq resReq) {
	            if (resReq == null)
	                return;
	            LocalTime gameTime = LocalTime.parse(resReq.getTime(), DateTimeFormatter.ofPattern("hh:mma"));
	            LocalDate gameDate =  LocalDate.parse(resReq.getDate(), DateTimeFormatter.ISO_LOCAL_DATE);
	            
	            Game game = new Game();
	            game.setTeam1(resReq.getTeam1());
	            game.setTeam2(resReq.getTeam2());
	            game.setVenue(resReq.getVenue());
	            game.setDate(LocalDateTime.of(gameDate, gameTime));
	            
	            this.reservation.game = game;
	            this.reservation.leather = resReq.isLeather();
	            this.reservation.requestingTeam = resReq.getRequestingTeam();
	            this.reservation.date = LocalDateTime.of(gameDate, gameTime);
	        }

	        public Reservation build() {
	            return this.reservation;
	        }


	    }
	
}
