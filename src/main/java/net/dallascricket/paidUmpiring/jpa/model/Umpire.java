package net.dallascricket.paidUmpiring.jpa.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Umpire {
	
	private Integer id;
	private String name;
	private boolean certified;
	
	
	
	public Umpire(String name, boolean certified) {
		super();
		this.name = name;
		this.certified = certified;
	}
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean isCertified() {
		return certified;
	}
	public void setCertified(boolean certified) {
		this.certified = certified;
	}
	
	

}
