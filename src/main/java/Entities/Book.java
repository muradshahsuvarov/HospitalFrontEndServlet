package Entities;

import java.time.LocalDateTime;

public class Book {

    public Integer bookId;
    public String bookEmail;
    public String bookName;
    public Integer patientId;
    public Integer doctorId;
    public Boolean isBooked;
    public LocalDateTime dateTime;

    public Book(Integer _bookId,
                String _bookEmail,
                String _bookName,
                Integer _patientId,
                Integer _doctorId,
                Boolean _isBooked,
                LocalDateTime _dateTime) {

        this.bookId = _bookId;
        this.bookEmail = _bookEmail;
        this.bookName = _bookName;
        this.patientId = _patientId;
        this.doctorId = _doctorId;
        this.isBooked = _isBooked;
        this.dateTime = _dateTime;
        
    }

    public Integer getBookId() { return this.bookId; }
    public String getBookName() { return this.bookName; }
    public Integer getPatient() { return this.patientId; }
    public Integer getDoctor() { return this.doctorId; }
    public Boolean getIsBooked() { return this.isBooked; }
    public LocalDateTime getDate() { return this.dateTime; }


    public void setBookId(Integer _slotId) { this.bookId = _slotId; }
    public void setBookName(String _bookName) { this.bookName = _bookName; }
    public void setPatient(Integer _patientId) { this.patientId = _patientId; }
    public void setDoctor(Integer _doctorId) { this.doctorId = _doctorId; }
    public void setIsBooked(Boolean _isBooked) { this.isBooked = _isBooked; }
    public void setDate(LocalDateTime _datetime) { this.dateTime = _datetime; }


    public void print() { }
}
