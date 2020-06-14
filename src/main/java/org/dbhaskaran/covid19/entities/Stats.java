package org.dbhaskaran.covid19.entities;


public class Stats {
	
	private int active;
	private String lastupdate;
	private int confirmed;
	private int deaths;
	private int recovered;
	
	public Stats() {
		
	}
	
	public Stats(int active, String lastupdate, int confirmed, int deaths, int recovered) {
		super();
		this.active = active;
		this.lastupdate = lastupdate;
		this.confirmed = confirmed;
		this.deaths = deaths;
		this.recovered = recovered;
	}

	public int getActive() {
		return active;
	}
	public void setActive(int active) {
		this.active = active;
	}
	public String getLastupdate() {
		return lastupdate;
	}
	public void setLastupdate(String lastupdate) {
		this.lastupdate = lastupdate;
	}
	public int getConfirmed() {
		return confirmed;
	}
	public void setConfirmed(int confirmed) {
		this.confirmed = confirmed;
	}
	public int getDeaths() {
		return deaths;
	}
	public void setDeaths(int deaths) {
		this.deaths = deaths;
	}
	public int getRecovered() {
		return recovered;
	}
	public void setRecovered(int recovered) {
		this.recovered = recovered;
	} 

}