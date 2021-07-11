package org.dbhaskaran.covid19.service;

import java.util.List;

import org.dbhaskaran.covid19.entities.Vax;

public interface IVaxService {

	Vax saveVax(Vax vax);

	Vax updateVax(Vax vax);

	void deleteVax(Vax vax);

	Vax getVaxbyId(long id);

	List<Vax> getAllVax();

	List<Vax> searchVax(String country);

}
