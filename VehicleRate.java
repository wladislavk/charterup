public class VehicleRate {
    private String vehicleType;
    private String pricingMethod;
    private int rateInCents;

    public void setPricingMethod(String pricingMethod) {
        this.pricingMethod = pricingMethod;
    }

    public void setRateInCents(int rateInCents) {
        this.rateInCents = rateInCents;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public String getPricingMethod() {
        return pricingMethod;
    }

    public int getRateInCents() {
        return rateInCents;
    }

    public String getVehicleType() {
        return vehicleType;
    }
}
