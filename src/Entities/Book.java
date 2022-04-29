package Entities;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Book {

    public Integer bookId;
    public String bookName;
    public Patient patient;
    public Doctor doctor;
    public Boolean isBooked;
    public LocalDateTime dateTime;

    public Book() { }

    public Integer getBookId() { return this.bookId; }
    public String getBookName() { return this.bookName; }
    public Patient getPatient() { return this.patient; }
    public Doctor getDoctor() { return this.doctor; }
    public Boolean getIsBooked() { return this.isBooked; }
    public LocalDateTime getDate() { return this.dateTime; }


    public void setBookId(Integer _slotId) { this.bookId = _slotId; }
    public void setBookName(String _bookName) { this.bookName = _bookName; }
    public void setPatient(Patient _patient) { this.patient = _patient; }
    public void setDoctor(Doctor _doctor) { this.doctor = _doctor; }
    public void setIsBooked(Boolean _isBooked) { this.isBooked = _isBooked; }
    public void setDate(LocalDateTime _datetime) { this.dateTime = _datetime; }
}
