package org.dbhaskaran.covid19.controllers;

import java.util.List;

import org.dbhaskaran.covid19.entities.Covid;
import org.dbhaskaran.covid19.service.CovidServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api")
public class CovidRestController {
	@Autowired
	CovidServiceImpl covidService;

	@GetMapping(value = "/", produces = "application/json")
	public List<Covid> getAll() {
		return covidService.getAllCovid();
	}

	@GetMapping(value = "/{country}", produces = "application/json")
	public List<Covid> getByCountry(@PathVariable String country) {
		return covidService.searchCovid(country);
	}

}
