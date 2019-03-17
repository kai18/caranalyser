package com.kaustubh.cognitree.caranalytics.model;

import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class Origin {

  public double totalHorsepower;
  String regionLabel;
  Queue<Car> cars;

  public Origin() {
    cars = new PriorityQueue<>(new HorsePowerComparator());
  }

  public String getRegionLabel() {
    return regionLabel;
  }

  public void setRegionLabel(String regionLabel) {
    this.regionLabel = regionLabel;
  }

  public double getTotalHorsepower() {
    return totalHorsepower;
  }

  public void setTotalHorsepower(double totalHorsepower) {
    this.totalHorsepower = totalHorsepower;
  }

  public Queue<Car> getCars() {
    return cars;
  }

  public void setCars(List<Car> cars) {
    totalHorsepower += cars.stream().map(Car::getHorsepower).mapToDouble(Double::doubleValue).sum();
    this.cars.addAll(cars);
  }

  public void setCar(Car car) {
    totalHorsepower += car.getHorsepower();
    this.cars.add(car);
  }

  public double getAverageHorsepower() {
    if (cars.isEmpty()) {
      throw new ArithmeticException(
          "There are no cars from this origin, can't calculate average horsepower");
    }
    return totalHorsepower / cars.size();
  }

  @Override
  public String toString() {
    return this.getRegionLabel();
  }
}
