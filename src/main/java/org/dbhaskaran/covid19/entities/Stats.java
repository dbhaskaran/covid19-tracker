package org.dbhaskaran.covid19.entities;


public class Stats {
	
	private int active;
	private String lastupdate;
	private int confirmed;
	private int deaths;
	private int recovered;
	private long population;
	private long dosesAdministered;
	private long peopleVaccinated;
	private long completedVaccination;
	
	
	public Stats(int active, String lastupdate, int confirmed, int deaths, int recovered) {
		super();
		this.active = active;
		this.lastupdate = lastupdate;
		this.confirmed = confirmed;
		this.deaths = deaths;
		this.recovered = recovered;
	}
	
	public Stats(long population, long dosesAdministered, long peopleVaccinated, long completedVaccination) {
		super();
		this.population = population;
		this.dosesAdministered = dosesAdministered;
		this.peopleVaccinated = peopleVaccinated;
		this.completedVaccination = completedVaccination;
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

	public long getPopulation() {
		return population;
	}

	public void setPopulation(long population) {
		this.population = population;
	}

	public long getDosesAdministered() {
		return dosesAdministered;
	}

	public void setDosesAdministered(long dosesAdministered) {
		this.dosesAdministered = dosesAdministered;
	}

	public long getPeopleVaccinated() {
		return peopleVaccinated;
	}

	public void setPeopleVaccinated(long peopleVaccinated) {
		this.peopleVaccinated = peopleVaccinated;
	}

	public long getCompletedVaccination() {
		return completedVaccination;
	}

	public void setCompletedVaccination(long completedVaccination) {
		this.completedVaccination = completedVaccination;
	} 

}