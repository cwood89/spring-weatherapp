package com.tts.WeatherApp.repository;

import com.tts.WeatherApp.model.ZipCode;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ZipCodeRepository extends JpaRepository<ZipCode, Long> {
  public ZipCode findByZip(String zipCode);

}