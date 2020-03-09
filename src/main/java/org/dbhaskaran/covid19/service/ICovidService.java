package org.dbhaskaran.covid19.service;

import java.util.List;

import org.dbhaskaran.covid19.entities.Covid;

public interface ICovidService {

	Covid saveCovid(Covid covid);

	Covid updateCovid(Covid covid);

	void deleteCovid(Covid covid);

	Covid getCovidbyId(int id);

	List<Covid> getAllCovid();

}