package org.dbhaskaran.covid19.repos;

import java.util.List;

import org.dbhaskaran.covid19.entities.Covid;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ICovid extends JpaRepository<Covid, Long> {

	List<Covid> findByCountryIgnoreCase(String country);

	Covid findByCountry(String country);
	
	@Query("SELECT SUM(confirmed) FROM Covid")
	Integer getTotalConfirmed();
	
	@Query("SELECT SUM(deaths) FROM Covid")
	Integer getTotalDeaths();
	
	@Query("SELECT SUM(recovered) FROM Covid")
	Integer getTotalrecovered();
	
	@Query("SELECT lastupdate FROM Covid"
			+ " WHERE country = 'India'")
	String getLastUpdated();

}