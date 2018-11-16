package net.dallascricket.paidUmpiring.jpa.model;

import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import net.dallascricket.paidUmpiring.Request.ReservationReq;
@Entity
public class Reservation {

	private Integer id;
	private Game game;
	private Umpire umpire;
	private Calendar date;
	private boolean leather;
	private String requestingTeam;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	@OneToOne
	@JoinColumn(name="game.id")	
	public Game getGame() {
		return game;
	}
	public void setGame(Game game) {
		this.game = game;
	}
	@OneToOne
	@JoinColumn(name="umpire.id")
	public Umpire getUmpire() {
		return umpire;
	}
	public void setUmpire(Umpire umpire) {
		this.umpire = umpire;
	}
	public Calendar getDate() {
		return date;
	}
	public void setDate(Calendar date) {
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
	            Game game = new Game();
	            game.setTeam1(resReq.getTeam1());
	            game.setTeam2(resReq.getTeam2());
	            game.setVenue(resReq.getVenue());
	            
	            this.reservation.game = game;
	            this.reservation.leather = resReq.isLeather();
	        }

	        public Reservation build() {
	            return this.reservation;
	        }


	    }
	
}
