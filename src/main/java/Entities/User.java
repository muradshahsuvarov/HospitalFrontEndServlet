package Entities;

import java.util.ArrayList;
import java.util.List;

public class User {

    protected  Integer userId;
    protected String name;
    protected String surname;
    protected String username;
    protected String email;
    protected String password;
    protected String phone;
    protected Integer age;
    protected String gender;
    protected boolean isDoctor;
    protected String personalInfo;

    protected String reminderEmail;
    protected String bookingEmail;
    protected List<Reminder> reminderList;
    protected List<Book> bookings;

    public User(String _name,
                String _surname,
                String _username,
                String _email,
                String _password,
                String _phone,
                Integer _age,
                String _gender,
                Boolean _isDoctor,
                String _personalInfo){

        this.name = _name;
        this.surname = _surname;
        this.username = _username;
        this.email = _email;
        this.password = _password;
        this.phone = _phone;
        this.age = _age;
        this.gender = _gender;
        this.isDoctor = _isDoctor;
        this.personalInfo = _personalInfo;
        this.reminderList = new ArrayList<Reminder>();
        this.bookings = new ArrayList<Book>();

    }

    public void print() {

        StringBuilder sb = new StringBuilder();
        sb.append(this.name);
        sb.append(this.surname);
        sb.append(this.username);
        sb.append(this.email);
        sb.append(this.password);
        sb.append(this.phone);
        sb.append(this.age);
        sb.append(this.gender);
        sb.append(this.isDoctor);
        sb.append(this.personalInfo);

        System.out.println(sb);
    }

    public String getName(){ return this.name; }

    public String getSurname() { return this.surname; }

    public String getUsername() { return this.username; }

    public String getEmail() { return this.email; }

    public String getPassword() { return this.password; }

    public String getPhone() { return this.phone; }

    public int getAge() { return this.age; }

    public String getGender() { return this.gender; }

    public boolean getIsDoctor() { return this.isDoctor; }

    public String getPersonalInfo() { return this.personalInfo; }

    public String getReminderEmail() { return this.reminderEmail; }

    public String getBookingEmail() { return this.bookingEmail; }

    public List<Reminder> getReminderList() { return this.reminderList; }

    public void setName(String _name) { this.name = _name; }

    public void setSurname(String _surname) { this.surname = _surname; }

    public void setUsername(String _username) { this.username = _username; }

    public void setEmail(String _email) { this.email = _email; }

    public void setPassword(String _password) { this.password = _password; }

    public void setPhone(String _phone) { this.phone = _phone; }

    public void setAge(int _age) { this.age = _age; }

    public void setGender(String _gender) { this.gender = _gender; }

    public void setIsDoctor(boolean _isDoctor) { this.isDoctor = _isDoctor; }

    public void setPersonalInfo(String _personalInfo) { this.personalInfo = _personalInfo; }

    public void setReminderEmail(String _reminderEmail) { this.reminderEmail = _reminderEmail; }

    public void setBookingEmail(String _bookingEmail) { this.bookingEmail = _bookingEmail; }

    public void setReminderList(List<Reminder> _reminderList) { this.reminderList = _reminderList; }

    public void addToHistory() { }

    public void register() { }

    public boolean enterAccount() { return false; }

    public boolean exitAccount() { return false; }

    public void viewAccount() {  }

    public void viewHistory() {  }

    public void viewHospital() {  }
}
