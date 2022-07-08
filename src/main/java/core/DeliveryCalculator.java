package core;

import parameters.Distance;
import parameters.Fragile;
import parameters.Size;
import parameters.Workload;

public class DeliveryCalculator {

    /**
     * Метод расчёта стоимости доставки
     *
     * @param distance - дистанция
     * @param size - габариты
     * @param isFragile - хрупкость
     * @param workload - загруженность
     *
     * @return сумма доставки (-1.0 в случае груза хрупкого + более 30 км)
     */
    public Double countDeliveryCost(Distance distance, Size size, Fragile isFragile, Workload workload) {
        var error = -1.0;
        var min = 400.0;

        if (isFragile.equals(Fragile.YES) && distance.equals(Distance.MORE_THAN_THIRTY)) {
            return error;
        }

        var sum = (distance.getDistCost() + size.getSizeCost() + isFragile.getFragCost()) * workload.getWorkloadCost();

        if (sum < 400) {
            return min;
        }
        return sum;
    }

}
