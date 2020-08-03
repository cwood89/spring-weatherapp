package com.tts.WeatherApp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import com.tts.WeatherApp.model.Response;
import com.tts.WeatherApp.model.ZipCode;
import com.tts.WeatherApp.repository.ZipCodeRepository;

@Service
public class WeatherService {

	@Value("${api_key}")
	private String apiKey;

	@Autowired
	private ZipCodeRepository zipCodeRepository;

	public List<ZipCode> getRecentSearches() {
		return zipCodeRepository.findAll();
	}

	public Response getForecast(String zipCode) {
		String url = "http://api.openweathermap.org/data/2.5/weather?zip=" + zipCode + "&units=imperial&appid=" + apiKey;
		RestTemplate restTemplate = new RestTemplate();

		ZipCode zip = new ZipCode(zipCode);

		try {
			if (zipCodeRepository.findByZip(zipCode) == null) {
				zipCodeRepository.save(zip);
			}
			return restTemplate.getForObject(url, Response.class);
		} catch (HttpClientErrorException ex) {
			Response response = new Response();
			response.setName("error");
			return response;
		}

	}

}
