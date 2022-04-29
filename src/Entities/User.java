package Entities;

import java.util.List;

public class User {

    protected String name;
    protected String surname;
    protected String username;
    protected String email;
    protected String password;
    protected String phone;
    protected int age;
    protected boolean gender;
    protected boolean isDoctor;
    protected String personalInfo;
    protected List<Reminder> reminderList;
    public List<Book> bookings;

    public User(){}

    public String getName(){ return this.name; }

    public String getSurname() { return this.surname; }

    public String getUsername() { return this.username; }

    public String getEmail() { return this.email; }

    public String getPassword() { return this.password; }

    public String getPhone() { return this.phone; }

    public int getAge() { return this.age; }

    public boolean getGender() { return this.gender; }

    public boolean getIsDoctor() { return this.isDoctor; }

    public String getPersonalInfo() { return this.personalInfo; }

    public List<Reminder> getReminderList() { return this.reminderList; }

    public void setName(String _name) { this.name = _name; }

    public void setSurname(String _surname) { this.surname = _surname; }

    public void setUsername(String _username) { this.username = _username; }

    public void setEmail(String _email) { this.email = _email; }

    public void setPassword(String _password) { this.password = _password; }

    public void setPhone(String _phone) { this.phone = _phone; }

    public void setAge(int _age) { this.age = _age; }

    public void setGender(boolean _gender) { this.gender = _gender; }

    public void setIsDoctor(boolean _isDoctor) { this.isDoctor = _isDoctor; }

    public void setPersonalInfo(String _personalInfo) { this.personalInfo = _personalInfo; }

    public void setReminderList(List<Reminder> _reminderList) { this.reminderList = _reminderList; }

    public void addToHistory() { }

    public void register() { }

    public boolean enterAccount() { return false; }

    public boolean exitAccount() { return false; }

    public void viewAccount() {  }

    public void viewHistory() {  }

    public void viewHospital() {  }
}
