package org.dbhaskaran.covid19.controllers;

import java.util.List;

import org.dbhaskaran.covid19.entities.Covid;
import org.dbhaskaran.covid19.entities.Stats;
import org.dbhaskaran.covid19.service.CovidServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/")
public class CovidRestController {
	@Autowired
	CovidServiceImpl covidService;

	@CrossOrigin
	@GetMapping(value = "countries/", produces = "application/json")
	public List<Covid> getAll() {
		return covidService.getAllCovid();
	}

	@CrossOrigin
	@GetMapping(value = "countries/{country}", produces = "application/json")
	public List<Covid> getByCountry(@PathVariable String country) {
		return covidService.searchCovid(country);
	}
	
	@CrossOrigin
	@GetMapping(value = "stats/", produces = "application/json")
	public Stats getStats() {
		return covidService.getStats();
	}

}