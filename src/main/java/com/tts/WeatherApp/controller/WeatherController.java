package com.tts.WeatherApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

import com.tts.WeatherApp.model.Request;
import com.tts.WeatherApp.model.Response;
import com.tts.WeatherApp.model.ZipCode;
import com.tts.WeatherApp.service.WeatherService;

@Controller
public class WeatherController {

	@Autowired
	private WeatherService weatherService;

	@GetMapping
	public String getIndex(Model model) {
		List<ZipCode> zipCodes = weatherService.getRecentSearches();
		model.addAttribute("request", new Request());
		model.addAttribute("zip_codes", zipCodes);
		return "index";
	}

	@PostMapping
	public String postIndex(Request request, Model model) {

		List<ZipCode> zipCodes = weatherService.getRecentSearches();
		Response data = weatherService.getForecast(request.getZipCode());
		model.addAttribute("data", data);
		model.addAttribute("zip_codes", zipCodes);

		return "index";

	}

}
