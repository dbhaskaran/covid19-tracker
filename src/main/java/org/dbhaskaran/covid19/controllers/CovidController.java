package org.dbhaskaran.covid19.controllers;

import java.util.List;

import org.dbhaskaran.covid19.entities.Covid;
import org.dbhaskaran.covid19.service.CovidServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CovidController {

	@Autowired
	CovidServiceImpl covidService;

	@RequestMapping("/")
	public String displayCovids(ModelMap modelMap) {
		List<Covid> allCovids = covidService.getAllCovid();
		modelMap.addAttribute("covids", allCovids);
		return "display";
	}

	@RequestMapping("/search")
	public String searchCovids(@RequestParam("country") String country, ModelMap modelMap) {
		List<Covid> allCovids = covidService.searchCovid(country);
		modelMap.addAttribute("covids", allCovids);
		return "display";
	}
}
