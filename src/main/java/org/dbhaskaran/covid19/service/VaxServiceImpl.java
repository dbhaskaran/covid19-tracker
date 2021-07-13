package org.dbhaskaran.covid19.service;

import java.util.List;
import java.util.Optional;

import org.dbhaskaran.covid19.entities.Stats;
import org.dbhaskaran.covid19.entities.Vax;
import org.dbhaskaran.covid19.repos.IVax;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VaxServiceImpl implements IVaxService {

	@Autowired
	private IVax vaxRepo;

	@Override
	public Vax saveVax(Vax vax) {
		return vaxRepo.save(vax);
	}

	@Override
	public Vax updateVax(Vax vax) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteVax(Vax vax) {
		// TODO Auto-generated method stub

	}

	@Override
	public Vax getVaxbyId(long id) {
		Optional<Vax> vaxopt = vaxRepo.findById(id);

		Vax vax = null;
		if (vaxopt.isPresent()) {
			vax = vaxopt.get();
		}
		return vax;
	}

	@Override
	public List<Vax> getAllVax() {
		return vaxRepo.findAll();
	}

	@Override
	public List<Vax> searchVax(String country) {
		return vaxRepo.findByCountryIgnoreCase(country);
	}
	
	@Override
	public Stats getStats() {
		long population = vaxRepo.getPopulation();
		long dosesAdministered = vaxRepo.getDosesAdministered();
		long peopleVaccinated= vaxRepo.getPeopleVaccinated();
		long completedVaccination = vaxRepo.getCompletedVaccination();
		
		return new Stats(population, dosesAdministered, peopleVaccinated, completedVaccination);
	}

}
