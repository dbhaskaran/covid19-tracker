package org.dbhaskaran.covid19.repos;

import java.util.List;

import org.dbhaskaran.covid19.entities.Vax;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IVax extends JpaRepository<Vax, Long> {

	List<Vax> findByCountryIgnoreCase(String country);

	Vax findByCountry(String country);
	
	@Query("SELECT SUM(population) FROM Vax")
	Long getPopulation();
	
	@Query("SELECT SUM(dosesAdministered) FROM Vax")
	Long getDosesAdministered();
	
	@Query("SELECT SUM(peopleVaccinated) FROM Vax")
	Long getPeopleVaccinated();

	@Query("SELECT SUM(completedVaccination) FROM Vax")
	Long getCompletedVaccination();


}
