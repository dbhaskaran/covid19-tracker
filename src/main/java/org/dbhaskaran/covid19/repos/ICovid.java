package org.dbhaskaran.covid19.repos;

import java.util.List;

import org.dbhaskaran.covid19.entities.Covid;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICovid extends JpaRepository<Covid, Long> {

	List<Covid> findByCountryContainingIgnoreCase(String country);

}
