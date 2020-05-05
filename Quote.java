import java.text.*;
import java.util.List;

/**
 * Retrieval of quotes based on rate data
 */
public class Quote {
    private List<VehicleRate> vehicleRates;

    /**
     * @param vehicleRates Data on available vehicles
     */
    public Quote(List<VehicleRate> vehicleRates) {
        this.vehicleRates = vehicleRates;
    }

    /**
     * Calculate vehicle rate in whole cents
     *
     * @param vehicleRate Data on currently selected vehicle rate
     * @param vehicleCount Number of vehicles needed
     * @param numberOfUnits Number of pricing units
     * @return Rate in whole cents
     */
    private int getRateInCents(VehicleRate vehicleRate, int vehicleCount, int numberOfUnits) {
        return vehicleCount * vehicleRate.getRateInCents() * numberOfUnits;
    }

    /**
     * Choose which rate is needed
     *
     * @param vehicleType Type of vehicle
     * @param pricingMethod Type of pricing
     * @return Data on needed vehicle rate
     */
    private VehicleRate getCurrentVehicleRate(String vehicleType, String pricingMethod) {
        for (VehicleRate vehicleRate: vehicleRates) {
            if (vehicleType.equals(vehicleRate.getVehicleType()) && pricingMethod.equals(vehicleRate.getPricingMethod())) {
                return vehicleRate;
            }
        }
        throw new RuntimeException("Quote cannot be found in the data set");
    }

    /**
     *
     * @param vehicleCount Number of vehicles needed
     * @param vehicleType Type of vehicle
     * @param pricingMethod Type of pricing
     * @param numberOfUnits Number of pricing units
     * @return Formatted rate: $#.##
     */
    public String getRate(int vehicleCount, String vehicleType, String pricingMethod, int numberOfUnits) {
        VehicleRate currentVehicleRate = getCurrentVehicleRate(vehicleType, pricingMethod);

        NumberFormat formatter = NumberFormat.getCurrencyInstance();
        double rateInCents = getRateInCents(currentVehicleRate, vehicleCount, numberOfUnits);
        double rateInDollars = rateInCents / 100;
        return formatter.format(rateInDollars);
    }
}
