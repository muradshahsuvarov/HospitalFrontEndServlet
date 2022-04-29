package  Entities;
import Entities.Book;

import java.time.LocalDate;
import java.util.List;

public class Schedule {

    public Integer scheduleId;
    public Doctor doctor;
    public List<Book> availableSlots;

    public Schedule(){}


    public void viewSchedule() { }
    public void viewAvailableSlots() { }
    public List<Book> getAvailableSlots() { return this.availableSlots; }
    public void setAvailableSlots(List<Book> _availableSlots) { this.availableSlots = _availableSlots;}
}
