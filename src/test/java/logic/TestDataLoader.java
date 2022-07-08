package logic;

import parameters.Distance;
import parameters.Fragile;
import parameters.Size;
import parameters.Workload;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class TestDataLoader {

    public Map<Distance, Double> loadDistances() {
        return Arrays.stream(Distance.values()).collect(Collectors.toMap(Function.identity(), Distance::getDistCost));
    }

    public Map<Size, Double> loadSizes() {
        return Arrays.stream(Size.values()).collect(Collectors.toMap(Function.identity(), Size::getSizeCost));
    }

    public Map<Fragile, Double> loadFragiles() {
        return Arrays.stream(Fragile.values()).collect(Collectors.toMap(Function.identity(), Fragile::getFragCost));
    }

    public Map<Workload, Double> loadWorkloads() {
        return Arrays.stream(Workload.values()).collect(Collectors.toMap(Function.identity(), Workload::getWorkloadCost));
    }

}
