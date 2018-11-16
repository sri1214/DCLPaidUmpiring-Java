package net.dallascricket.paidUmpiring.Request;

public class ReservationReq {
	private String team1;
	private String team2;
	private String venue;
	private String date;
	private String time;
	private String requestingTeam;
	private boolean leather;
	public String getTeam1() {
		return team1;
	}
	public void setTeam1(String team1) {
		this.team1 = team1;
	}
	public String getTeam2() {
		return team2;
	}
	public void setTeam2(String team2) {
		this.team2 = team2;
	}
	public String getVenue() {
		return venue;
	}
	public void setVenue(String venue) {
		this.venue = venue;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getRequestingTeam() {
		return requestingTeam;
	}
	public void setRequestingTeam(String requestingTeam) {
		this.requestingTeam = requestingTeam;
	}
	public boolean isLeather() {
		return leather;
	}
	public void setLeather(boolean leather) {
		this.leather = leather;
	}
	
	

}
