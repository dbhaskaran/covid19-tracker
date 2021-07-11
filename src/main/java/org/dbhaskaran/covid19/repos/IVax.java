package org.dbhaskaran.covid19.repos;

import java.util.List;

import org.dbhaskaran.covid19.entities.Vax;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IVax extends JpaRepository<Vax, Long> {

	List<Vax> findByCountryIgnoreCase(String country);

	Vax findByCountry(String country);

}
