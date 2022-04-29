package Entities;

import java.util.List;

public class Patient extends User {

    public int patientId;

    public List<Payment> payments;

    public List<Feedback> feedbacks;


    public Patient() { }


    public Doctor searchDoctor(String doctorName) { return null; }

    public void viewSchedule() { }

    public void bookAppointment() { }

    public void makePayment() { }

    public void setReminder() { }

    public void provideFeedback() { }

    public int getPatientId() { return this.patientId; }

    public void setPatientId(int _id) { this.patientId = _id;}

    public void viewPriceList() { }

    public void viewHistory() { }
}
