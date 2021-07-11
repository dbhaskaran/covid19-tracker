package org.dbhaskaran.covid19.controllers;

import java.util.List;

import org.dbhaskaran.covid19.entities.Vax;
import org.dbhaskaran.covid19.service.VaxServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class VaxController {

	@Autowired
	VaxServiceImpl vaxService;

	@RequestMapping("/vax")
	public String displayVax(ModelMap modelMap) {
		List<Vax> allVax = vaxService.getAllVax();
		modelMap.addAttribute("vax", allVax);
		return "displayVax";
	}

	@RequestMapping("/vax/search")
	public String searchVax(@RequestParam("country") String country, ModelMap modelMap) {
		List<Vax> allVax = vaxService.searchVax(country);
		modelMap.addAttribute("vax", allVax);
		return "displayVax";
	}

}
