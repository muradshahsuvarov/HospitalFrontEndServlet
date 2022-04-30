package Entities;

public class Hospital {

    public Integer hospitalId;
    public String hospitalName;
    public String hospitalAddress;

    public Hospital(Integer _hospitalId, String _hospitalName, String hospitalAddress) {
        this.hospitalId = _hospitalId;
        this.hospitalName = _hospitalName;
        this.hospitalAddress = hospitalAddress;
    }

    public void viewHospital(){ }

    public void print(){}

}
