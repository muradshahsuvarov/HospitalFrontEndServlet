package Entities;

public class Account {

    public String username;
    public String password;
    public Boolean isAuthenticated;

    public User user;
    public Doctor doctor;
    public Patient patient;

    public Account(String _username, String _password) {
        this.username = _username;
        this.password = _password;
    }

    public void Search() { }

    public void EditInformation(){ }

    public void DeleteInformation() { }

    public void BookAppointment() { }
}
