package org.dbhaskaran.covid19.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Vax {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String country;
	private long population;
	private long dosesAdministered;
	private long peopleVaccinated;
	private long completedVaccination;

	public Vax() {

	}

	public Vax(String country, long population, long dosesAdministered, long peopleVaccinated,
			long completedVaccination) {
		super();
		this.country = country;
		this.population = population;
		this.dosesAdministered = dosesAdministered;
		this.peopleVaccinated = peopleVaccinated;
		this.completedVaccination = completedVaccination;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
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

	@Override
	public String toString() {
		return "Vax [id=" + id + ", country=" + country + ", population=" + population + ", dosesAdministered="
				+ dosesAdministered + ", peopleVaccinated=" + peopleVaccinated + ", completedVaccination="
				+ completedVaccination + "]";
	}

}
