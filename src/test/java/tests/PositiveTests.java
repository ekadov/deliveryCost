package tests;

import core.DeliveryCalculator;
import logic.TestDataLoader;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import parameters.Distance;
import parameters.Fragile;
import parameters.Size;
import parameters.Workload;

import java.util.HashMap;
import java.util.Map;


public class PositiveTests {

    private Map<Distance, Double> distances = new HashMap<>();
    private Map<Size, Double> sizes = new HashMap<>();
    private Map<Fragile, Double> fragiles = new HashMap<>();
    private Map<Workload, Double> workloads = new HashMap<>();


    @BeforeClass
    public void setup() {
        TestDataLoader testDataLoader = new TestDataLoader();
        distances = testDataLoader.loadDistances();
        sizes = testDataLoader.loadSizes();
        fragiles = testDataLoader.loadFragiles();
        workloads = testDataLoader.loadWorkloads();
    }

    @Test
    public void testThatMethodCountsCorrectlyExceptMinAndError() {
        DeliveryCalculator deliveryCalculator = new DeliveryCalculator();
        distances.forEach((k1, v1) -> {
            sizes.forEach((k2, v2) -> {
                fragiles.forEach((k3, v3) -> {
                    workloads.forEach((k4, v4) -> {
                        var expected = (v1 + v2 + v3) * v4;
                        var actual = deliveryCalculator.countDeliveryCost(k1, k2, k3, k4);
                        if ((k3.equals(Fragile.YES) && k1.equals(Distance.MORE_THAN_THIRTY)) || expected < 400.0) {
                            return;
                        }
                        SoftAssert softAssert = new SoftAssert();
                        softAssert.assertEquals(actual, expected);
                    });
                });
            });
        });
    }

    @Test
    public void testThatMethodReturnsMinimal() {
        DeliveryCalculator deliveryCalculator = new DeliveryCalculator();
        var sum = deliveryCalculator
                .countDeliveryCost(Distance.LESS_THAN_TWO, Size.SMALL, Fragile.NO, Workload.OTHER);
        Assert.assertEquals(sum, 400.0);
    }

    @Test
    public void testThatFragilePlusLongDistanceReturnsNegativeResult() {
        DeliveryCalculator deliveryCalculator = new DeliveryCalculator();
        var distance = Distance.MORE_THAN_THIRTY;
        var fragile = Fragile.YES;
        for (Size size : Size.values()) {
            for (Workload workload : Workload.values()) {
                var sum = deliveryCalculator
                        .countDeliveryCost(distance, size, fragile, workload);
                Assert.assertEquals(sum, -1.0);
            }
        }

    }

}
