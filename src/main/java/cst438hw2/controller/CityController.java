package cst438hw2.controller;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import cst438hw2.domain.CityInfo;
import cst438hw2.domain.CityRepository;
import cst438hw2.domain.CountryRepository;
import cst438hw2.service.CityService;
 
//The CityController class handles HTTP routing requests. URL is: localhost:8080/cities/city 
@Controller
public class CityController {
	
	@Autowired
	CityRepository cityRepository;
	@Autowired
	CountryRepository countryRepository;
	@Autowired
	CityService cityService;
	
    //TO ADD
    //kelvin to Fahrenheit : (temp - 273.15) * 9.0/5.0 + 32.0;
	@GetMapping("/cities/{city}")
	public String getCityInfo(@PathVariable("city") String cityName, 
                               Model model) {
      CityInfo cityInfo = cityService.getCityInfo(cityName);
      
      //Consider simply adding the CityInfo object to the model without adding the individual
      //parameters. You can add the individual parameters of CityInfo via the HTML Template.
      //This would be cleaner and DRYer.
      //model.addAttribute("cityInfo", cityInfo);
      model.addAttribute("ID", cityInfo.city.getID());
      model.addAttribute("name", cityName);
      model.addAttribute("countryCode", cityInfo.country.getCode());
      model.addAttribute("countryName", cityInfo.country.getName());
      model.addAttribute("district", cityInfo.city.getDistrict());
      model.addAttribute("population", cityInfo.city.getPopulation());
      model.addAttribute("localWeather", cityInfo.tempAndTime.temp);
      model.addAttribute("localTime", cityInfo.tempAndTime.time);
      
      return "city_info";
     }
}

