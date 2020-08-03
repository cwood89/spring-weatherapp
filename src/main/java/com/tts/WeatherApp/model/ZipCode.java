package com.tts.WeatherApp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@NoArgsConstructor
@Entity
public class ZipCode {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @NonNull
  private Long id;

  @NonNull
  @Column(unique = true)
  private String zip;

  public ZipCode(String zip) {
    this.zip = zip;
  }

}