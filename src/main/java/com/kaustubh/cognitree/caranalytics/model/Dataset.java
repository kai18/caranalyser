package com.kaustubh.cognitree.caranalytics.model;

import com.kaustubh.cognitree.caranalytics.exceptions.OriginNotFoundException;
import java.io.File;
import java.util.Map;

public class Dataset {

  private String filePath;
  private File datasetFile;
  private Map<String, Origin> data;

  public String getFilePath() {
    return filePath;
  }

  public void setFilePath(String filePath) {
    this.filePath = filePath;
  }

  public File getDatasetFile() {
    return datasetFile;
  }

  public void setDatasetFile(File datasetFile) {
    this.datasetFile = datasetFile;
  }

  public Map<String, Origin> getData() {
    return data;
  }

  public void setData(
      Map<String, Origin> data) {
    this.data = data;
  }

  public Origin getOrigin(String originName) throws OriginNotFoundException {
    Origin origin = data.get(originName);
    if (origin == null) {
      throw new OriginNotFoundException("Origin with label " + originName + " does not exists");
    }
    return origin;
  }
}
