package  Entities;

public class Schedule {

    public Integer scheduleId;
    public Integer bookingsEmail;

    public Schedule(Integer _scheduleId) {
        this.scheduleId = _scheduleId;
    }


    public void viewSchedule() { }
    public void viewAvailableSlots() { }
    public Integer getAvailableSlotId() { return this.bookingsEmail; }
    public void setAvailableSlots(Integer _availableSlots) { this.bookingsEmail = _availableSlots;}

    public void print() {}
}
