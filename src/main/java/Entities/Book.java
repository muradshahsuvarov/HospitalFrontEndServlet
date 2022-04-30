package Entities;

import java.time.LocalDateTime;

public class Book {

    public Integer bookId;
    public String bookName;
    public String patientEmail;
    public String doctorEmail;
    public Boolean isBooked;
    public LocalDateTime dateTime;

    public Book(Integer _bookId,
                String _bookName,
                String _patientEmail,
                String _doctorEmail,
                Boolean _isBooked,
                LocalDateTime _dateTime) {

        this.bookId = _bookId;
        this.bookName = _bookName;
        this.patientEmail = _patientEmail;
        this.doctorEmail = _doctorEmail;
        this.isBooked = _isBooked;
        this.dateTime = _dateTime;
        
    }

    public Integer getBookId() { return this.bookId; }
    public String getBookName() { return this.bookName; }
    public String getPatientEmail() { return this.patientEmail; }
    public String getDoctorEmail() { return this.doctorEmail; }
    public Boolean getIsBooked() { return this.isBooked; }
    public LocalDateTime getDate() { return this.dateTime; }


    public void setBookId(Integer _slotId) { this.bookId = _slotId; }
    public void setBookName(String _bookName) { this.bookName = _bookName; }
    public void setPatient(String _patientEmail) { this.patientEmail = _patientEmail; }
    public void setDoctor(String _doctorEmail) { this.doctorEmail = _doctorEmail; }
    public void setIsBooked(Boolean _isBooked) { this.isBooked = _isBooked; }
    public void setDate(LocalDateTime _datetime) { this.dateTime = _datetime; }


    public void print() { }
}
