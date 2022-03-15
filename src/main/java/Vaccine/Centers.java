package Vaccine;


import java.util.Arrays;

class Vaccine_Fees {
    private String vaccine;
    private int fee;

    public Vaccine_Fees() {
    }

    public Vaccine_Fees(String vaccine, int fee) {
        this.vaccine = vaccine;
        this.fee = fee;
    }
}

public class Centers {
    private long center_id;
    private String name;
    private String address;
    private String state_name;
    private String block_name;
    private int pincode;
    private String from;
    private String to;
    private String fee_type;
    private Sessions[] sessions;
    private Vaccine_Fees[] vaccine_fees;

    public Centers() {
    }

    public Centers(long center_id, String name, String address, String state_name, String block_name, int pincode, String from, String to, String fee_type, Sessions[] sessions, Vaccine_Fees[] vaccine_fees) {
        this.center_id = center_id;
        this.name = name;
        this.address = address;
        this.state_name = state_name;
        this.block_name = block_name;
        this.pincode = pincode;
        this.from = from;
        this.to = to;
        this.fee_type = fee_type;
        this.sessions = sessions;
        this.vaccine_fees = vaccine_fees;
    }

    public long getCenter_id() {
        return center_id;
    }

    public void setCenter_id(long center_id) {
        this.center_id = center_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getState_name() {
        return state_name;
    }

    public void setState_name(String state_name) {
        this.state_name = state_name;
    }

    public String getBlock_name() {
        return block_name;
    }

    public void setBlock_name(String block_name) {
        this.block_name = block_name;
    }

    public int getPincode() {
        return pincode;
    }

    public void setPincode(int pincode) {
        this.pincode = pincode;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getFee_type() {
        return fee_type;
    }

    public void setFee_type(String fee_type) {
        this.fee_type = fee_type;
    }

    public Sessions[] getSessions() {
        return sessions;
    }

    public void setSessions(Sessions[] sessions) {
        this.sessions = sessions;
    }

    public Vaccine_Fees[] getVaccine_fees() {
        return vaccine_fees;
    }

    public void setVaccine_fees(Vaccine_Fees[] vaccine_fees) {
        this.vaccine_fees = vaccine_fees;
    }

    @Override
    public String toString() {
        return "Centers{" +
                "center_id=" + center_id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", state_name='" + state_name + '\'' +
                ", block_name='" + block_name + '\'' +
                ", pincode=" + pincode +
                ", from='" + from + '\'' +
                ", to='" + to + '\'' +
                ", fee_type='" + fee_type + '\'' +
                ", sessions=" + Arrays.toString(sessions) +
                ", vaccine_fees=" + Arrays.toString(vaccine_fees) +
                '}';
    }
}
