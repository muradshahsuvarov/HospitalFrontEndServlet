package  Entities;

public class Schedule {

    public Integer scheduleId;
    public String ownerEmail;

    public Schedule(Integer _scheduleId,
                    String _ownerEmail) {
        this.scheduleId = _scheduleId;
        this.ownerEmail = _ownerEmail;
    }


    public void viewSchedule() { }
    public void viewAvailableSlots() { }

    public void print() {}
}
