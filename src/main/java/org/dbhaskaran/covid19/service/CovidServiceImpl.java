package org.dbhaskaran.covid19.service;

import java.util.List;
import java.util.Optional;

import org.dbhaskaran.covid19.entities.Covid;
import org.dbhaskaran.covid19.repos.ICovid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CovidServiceImpl implements ICovidService {

	@Autowired
	private ICovid covidRepo;

	@Override
	public Covid saveCovid(Covid covid) {
		return covidRepo.save(covid);
	}

	@Override
	public Covid updateCovid(Covid covid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteCovid(Covid covid) {
		// TODO Auto-generated method stub

	}

	@Override
	public Covid getCovidbyId(long id) {
		Optional<Covid> covidopt = covidRepo.findById(id);

		Covid cov = null;
		if (covidopt.isPresent()) {
			cov = covidopt.get();
		}
		return cov;
	}

	@Override
	public List<Covid> getAllCovid() {
		return covidRepo.findAll();
	}

	@Override
	public List<Covid> searchCovid(String country) {
		return covidRepo.findByCountryContainingIgnoreCase(country);
	}

}
