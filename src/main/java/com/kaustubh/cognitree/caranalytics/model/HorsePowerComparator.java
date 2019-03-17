package com.kaustubh.cognitree.caranalytics.model;

import java.util.Comparator;

/**
 * Car comparator used to sort cars in descending order of their horsepower
 */
public class HorsePowerComparator implements Comparator<Car> {


  @Override
  public int compare(Car o1, Car o2) {
    if (o1.getHorsepower() > o2.getHorsepower()) {
      return -1;
    } else {
      return 1;
    }
  }

}
