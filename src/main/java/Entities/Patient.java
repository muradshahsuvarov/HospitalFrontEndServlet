package Entities;

import java.util.ArrayList;
import java.util.List;

public class Patient extends User {

    public Search search;

    public List<Payment> payments;

    public List<Feedback> feedbacks;


    public Patient(User _user) {

        super (
                _user.getName(),
                _user.getSurname(),
                _user.getUsername(),
                _user.getEmail(),
                _user.getPassword(),
                _user.getPhone(),
                _user.getAge(),
                _user.getGender(),
                _user.getIsDoctor(),
                _user.getPersonalInfo()
        );

        this.payments = new ArrayList<Payment>();
        this.feedbacks = new ArrayList<Feedback>();
        this.search = new Search();

    }


    public Doctor searchDoctor(String doctorName) { return null; }

    public void viewSchedule() { }

    public void bookAppointment() { }

    public void makePayment() { }

    public void setReminder() { }

    public void provideFeedback() { }

    public void viewPriceList() { }

    public void viewHistory() { }
}
