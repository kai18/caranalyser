package com.kaustubh.cognitree.caranalytics.model;

import java.util.Objects;

public class Car {

  private String name;
  private Double horsepower;
  private Origin origin;

  public Car() {
  }

  public Car(String name, Double horsepower, Origin origin) {
    this.name = name;
    this.horsepower = horsepower;
    this.origin = origin;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Double getHorsepower() {
    return horsepower;
  }

  public void setHorsepower(Double horsepower) {
    this.horsepower = horsepower;
  }

  public Origin getOrigin() {
    return origin;
  }

  public void setOrigin(Origin origin) {
    this.origin = origin;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Car car = (Car) o;
    return getName().equals(car.getName()) &&
        getHorsepower().equals(car.getHorsepower()) &&
        getOrigin().equals(car.getOrigin());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getName(), getHorsepower(), getOrigin());
  }

  @Override
  public String toString() {
    return this.getName()+"," + this.getHorsepower() + "," + this.getOrigin();
  }
}
