package com.kaustubh.cognitree.caranalytics.analyser;

import com.kaustubh.cognitree.caranalytics.model.Car;
import com.kaustubh.cognitree.caranalytics.model.Origin;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class GreaterThanAverageAnalyser {


  public static List<Car> analyse(int n, Origin origin) {
    return getCars(n, origin);
  }

  public static List<Car> getCars(int n, Origin origin) {
    Queue<Car> cars = origin.getCars();
    List<Car> result = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      if (cars.peek().getHorsepower() > origin.getAverageHorsepower()) {
        result.add(cars.peek());
        cars.poll();
      } else {
        break;
      }
    }
    return result;
  }

}
