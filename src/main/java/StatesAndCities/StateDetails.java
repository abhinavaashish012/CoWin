package StatesAndCities;

import java.util.Arrays;

public class StateDetails {
    private District[] districts;
    private int ttl;

    public StateDetails() {
    }

    public StateDetails(District[] districts, int ttl) {
        this.districts = districts;
        this.ttl = ttl;
    }

    public District[] getDistricts() {
        return districts;
    }

    public void setDistricts(District[] districts) {
        this.districts = districts;
    }

    public int getTtl() {
        return ttl;
    }

    public void setTtl(int ttl) {
        this.ttl = ttl;
    }

    @Override
    public String toString() {
        return "StatesAndCities.StateDetails{" +
                "districts=" + Arrays.toString(districts) +
                ", ttl=" + ttl +
                '}';
    }
}
