package Vaccine;

import java.util.Arrays;

public class CenterList {

    private Centers[] centers;

    public CenterList() {
    }

    public CenterList(Centers[] centers) {
        this.centers = centers;
    }

    public Centers[] getCenters() {
        return centers;
    }

    public void setCenters(Centers[] centers) {
        this.centers = centers;
    }

    @Override
    public String toString() {
        return "CenterList{" +
                "centers=" + Arrays.toString(centers) +
                '}';
    }
}
