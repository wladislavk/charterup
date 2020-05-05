import java.text.*;
import java.util.List;

public class Quote {
    private List<VehicleRate> vehicleRates;

    public Quote(List<VehicleRate> vehicleRates) {
        this.vehicleRates = vehicleRates;
    }

    private int getRateInCents(VehicleRate vehicleRate, int vehicleCount, int numberOfUnits) {
        return vehicleCount * vehicleRate.getRateInCents() * numberOfUnits;
    }

    private VehicleRate getCurrentVehicleRate(String vehicleType, String pricingMethod) {
        for (VehicleRate vehicleRate: vehicleRates) {
            if (vehicleType.equals(vehicleRate.getVehicleType()) && pricingMethod.equals(vehicleRate.getPricingMethod())) {
                return vehicleRate;
            }
        }
        throw new RuntimeException("Quote cannot be found in the data set");
    }

    public String getRate(int vehicleCount, String vehicleType, String pricingMethod, int numberOfUnits) {
        VehicleRate currentVehicleRate = getCurrentVehicleRate(vehicleType, pricingMethod);

        NumberFormat formatter = NumberFormat.getCurrencyInstance();
        double rateInCents = getRateInCents(currentVehicleRate, vehicleCount, numberOfUnits);
        double rateInDollars = rateInCents / 100;
        return formatter.format(rateInDollars);
    }
}
