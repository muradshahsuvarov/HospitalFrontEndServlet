package Entities;

import Entities.Patient;

import java.time.LocalDateTime;

public class Payment {

    public Integer paymentId;
    public LocalDateTime dateTime;
    public Patient patient;
    public Doctor doctor;
    public Integer amount;
    public Hospital hospital;

    public Payment() { }

    public Boolean validateAccount() { return false; }
    public Boolean withdrawAccount() { return false; }

    public Patient getPatient() { return this.patient; }
    public Integer getAmount() { return this.amount; }
    public Hospital getHospital() { return this.hospital; }

    public void setPatient(Patient _patient) {
        this.patient = _patient;
    }

    public void setAmount(Integer _amount) {
        this.amount = _amount;
    }

    public void setHospital(Hospital _hospital){ this.hospital = _hospital; }
}
