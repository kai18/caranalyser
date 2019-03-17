import com.kaustubh.cognitree.caranalytics.analyser.GreaterThanAverageAnalyser;
import com.kaustubh.cognitree.caranalytics.model.Car;
import com.kaustubh.cognitree.caranalytics.model.Origin;
import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class GreaterThanAnalyserTest {


  private List<Car> carList;
  private Origin usOrigin;

  @Before
  public void prepareData() {
    usOrigin = new Origin();
    usOrigin.setRegionLabel("US");

    Car car = new Car("Toyota Chevrolet", 230.76, usOrigin);

    Car car1 = new Car("Bugatti Veron", 350.53, usOrigin);

    Car car2 = new Car("Volkswagon", 130.00, usOrigin);

    carList = new ArrayList<>();
    carList.add(car);
    carList.add(car1);
    carList.add(car2);
    usOrigin.setCars(carList);
  }

  @Test
  public void testSuccess() {
    List<Car> result = GreaterThanAverageAnalyser.analyse(1, usOrigin);
    List<Car> expected = new ArrayList<>();
    expected.add(carList.get(1));
    Assert.assertNotNull(result);
    Assert.assertEquals(result.size(), 1);
    Assert.assertEquals(expected, result);
  }
}
