package com.kaustubh.cognitree.caranalytics;

import com.kaustubh.cognitree.caranalytics.analyser.GreaterThanAverageAnalyser;
import com.kaustubh.cognitree.caranalytics.datasetio.DatasetReader;
import com.kaustubh.cognitree.caranalytics.exceptions.DataSetReaderException;
import com.kaustubh.cognitree.caranalytics.exceptions.OriginNotFoundException;
import com.kaustubh.cognitree.caranalytics.model.Car;
import com.kaustubh.cognitree.caranalytics.model.Dataset;
import java.util.List;

public class ApplicationLauncher {

  public static void main(String args[]) {

    try {
      String filePath = args[0];
      Integer n = Integer.parseInt(args[1]);
      String origin = args[2];

      if (filePath == null || n == null || origin == null) {
        throw new IllegalArgumentException("All parameters must be passed");
      }

      Dataset dataset = DatasetReader.constructDatasetFromFile(filePath);
      List<Car> cars = GreaterThanAverageAnalyser.analyse(n, dataset.getOrigin(origin));
      for (Car car : cars) {
        System.out.println(car);
      }
    } catch (IllegalArgumentException | ArrayIndexOutOfBoundsException e) {
      System.out.println(e.getMessage() + " USAGE: mvn:exec FILEPATH NUMBER_OF_CARS_TO_RETURN ORIGIN_OF_CARS");
    } catch (DataSetReaderException | OriginNotFoundException e) {
      System.out.println("Analysis failed CAUSE: " + e.getMessage());
    } catch (Exception e) {
      System.out.println("Analysis failed CAUSE: " + e.getMessage());
    }
  }
}
