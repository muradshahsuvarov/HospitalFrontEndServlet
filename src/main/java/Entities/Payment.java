package Entities;

import java.time.LocalDateTime;

public class Payment {

    public Integer paymentId;
    public Integer patientId;
    public Integer doctorId;
    public Integer amount;
    public Integer hospitalId;
    public LocalDateTime dateTime;

    public Payment(
            Integer _paymentId,
            Integer _patientId,
            Integer _doctorId,
            Integer _amount,
            Integer _hospitalId,
            LocalDateTime _dateTime) {

        this.paymentId = _paymentId;
        this.patientId = _patientId;
        this.doctorId = _doctorId;
        this.amount = _amount;
        this.hospitalId = _hospitalId;
        this.dateTime = _dateTime;

    }

    public Boolean validateAccount() { return false; }
    public Boolean withdrawAccount() { return false; }

    public Integer getPatientId() { return this.patientId; }
    public Integer getAmount() { return this.amount; }
    public Integer getHospitalId() { return this.hospitalId; }

    public void setPatient(Integer _patient) {
        this.patientId = _patient;
    }

    public void setAmount(Integer _amount) {
        this.amount = _amount;
    }

    public void setHospital(Integer _hospital){ this.hospitalId = _hospital; }

    public void print() { }
}
