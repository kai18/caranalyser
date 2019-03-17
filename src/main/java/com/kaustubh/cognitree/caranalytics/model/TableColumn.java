package com.kaustubh.cognitree.caranalytics.model;

public enum TableColumn {
  CAR_NAME(0), ORIGIN(1), HORSEPOWER(2);

  int i;

  TableColumn(int i) {
    this.i = i;
  }

  public int getIndex() {
    return i;
  }
}
