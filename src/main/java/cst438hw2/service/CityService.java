package cst438hw2.service;
 
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cst438hw2.domain.*;
 
@Service
public class CityService {
	
	@Autowired
	private CityRepository cityRepository;
	@Autowired
	private CountryRepository countryRepository;
	@Autowired
	private WeatherService weatherService;
	
	//CityService adds City and Country data from the database into a CityInfo helper class object
	public CityInfo getCityInfo(String cityName) {
		
		List<City> cityList = cityRepository.findByName(cityName);
		City city = cityList.get(0);
		Country country = countryRepository.findByCode(cityName);
		TempAndTime tempAndTime = weatherService.getTempAndTime(cityName);
		CityInfo cityInfo = new CityInfo(city, country, tempAndTime);
		
		return cityInfo; 
     }
}
