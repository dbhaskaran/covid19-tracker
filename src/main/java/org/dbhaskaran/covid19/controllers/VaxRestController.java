package org.dbhaskaran.covid19.controllers;

import java.util.List;

import org.dbhaskaran.covid19.entities.Covid;
import org.dbhaskaran.covid19.entities.Stats;
import org.dbhaskaran.covid19.entities.Vax;
import org.dbhaskaran.covid19.service.VaxServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/")
public class VaxRestController {
	@Autowired
	VaxServiceImpl vaxService;

	@CrossOrigin
	@GetMapping(value = "vax/countries/", produces = "application/json")
	public List<Vax> getAll() {
		return vaxService.getAllVax();
	}

	@CrossOrigin
	@GetMapping(value = "vax/countries/{country}", produces = "application/json")
	public List<Vax> getByCountry(@PathVariable String country) {
		return vaxService.searchVax(country);
	}
	
	@CrossOrigin
	@GetMapping(value = "vax/stats/", produces = "application/json")
	public Stats getStats() {
		return vaxService.getStats();
	}

}