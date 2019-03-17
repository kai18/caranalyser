package com.kaustubh.cognitree.caranalytics.datasetio;

import com.kaustubh.cognitree.caranalytics.exceptions.DataSetReaderException;
import com.kaustubh.cognitree.caranalytics.model.Car;
import com.kaustubh.cognitree.caranalytics.model.Dataset;
import com.kaustubh.cognitree.caranalytics.model.Origin;
import com.kaustubh.cognitree.caranalytics.model.TableColumn;
import com.sun.org.apache.xerces.internal.impl.xs.opti.DefaultElement;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class DatasetReader {

  private static final String DELIMETER = ",";

  /**
   *
   * @param filePath
   * @return
   * @throws DataSetReaderException
   */
  public static Dataset constructDatasetFromFile(String filePath) throws DataSetReaderException {
    Dataset dataset = new Dataset();
    dataset.setDatasetFile(new File(filePath));
    dataset.setFilePath(filePath);
    try {
      dataset.setData(readData(dataset.getDatasetFile()));
    } catch (IOException e) {
      throw new DataSetReaderException(
          "Error occurred reading the data set file with path " + filePath + " CAUSE:" + e
              .getMessage());
    }

    return dataset;
  }

  /**
   *
   * @param datasetFile
   * @return
   * @throws IOException
   */
  public static Map<String, Origin> readData(File datasetFile) throws IOException {
    FileReader fileInputStream = new FileReader(datasetFile);
    BufferedReader reader = new BufferedReader(fileInputStream);
    reader.readLine();
    Map<String, Origin> originMap = new HashMap<>();

    String carInfo;
    while ((carInfo = reader.readLine()) != null) {
      String arr[] = carInfo.split(DELIMETER);
      Origin origin;

      if (originMap.containsKey(arr[TableColumn.ORIGIN.getIndex()])) {
        origin = originMap.get(arr[TableColumn.ORIGIN.getIndex()]);
      } else {
        origin = new Origin();
        origin.setRegionLabel(arr[TableColumn.ORIGIN.getIndex()]);
        originMap.put(origin.getRegionLabel(), origin);
      }

      Car car = new Car();
      car.setName(arr[TableColumn.CAR_NAME.getIndex()]);
      car.setHorsepower(Double.parseDouble(arr[TableColumn.HORSEPOWER.getIndex()]));
      car.setOrigin(origin);
      origin.setCar(car);
    }

    return originMap;
  }
}
