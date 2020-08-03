package com.tts.WeatherApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.tts.WeatherApp.model.Request;
import com.tts.WeatherApp.model.Response;
import com.tts.WeatherApp.service.WeatherService;

@Controller
public class WeatherController {
	
	@Autowired
	private WeatherService weatherService; 
	
	@GetMapping
	public String getIndex(Model model) {
//		Response response = weatherService.getForecast("06105");
		model.addAttribute("request", new Request()); 
//		model.addAttribute("data", response); 
		return "index"; 
	}
	
	@PostMapping
	public String PostIndex(Request request, Model model) {
		Response data = weatherService.getForecast(request.getZipCode()); 
		model.addAttribute("data", data); 
		return "index"; 
	}
	
}
