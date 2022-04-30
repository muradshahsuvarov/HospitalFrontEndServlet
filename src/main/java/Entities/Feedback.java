package Entities;

import java.time.LocalDateTime;

public class Feedback {

    public Integer feedbackId;
    public Integer patientId;
    public Integer doctorId;
    public String description;
    public LocalDateTime dateTime;

    public Feedback(
            Integer _feedbackId,
            Integer _patientId,
            Integer _doctorId,
            String _description,
            LocalDateTime _dateTime
    ) {
        this.feedbackId = _feedbackId;
        this.patientId = _patientId;
        this.doctorId = _doctorId;
        this.description = _description;
        this.dateTime = _dateTime;
    }

    public String getDescription() { return this.description; }
    public void setDescription(String _feedback) { this.description = _feedback; }
    public void viewFeedback() { }

    public void print() { }
}
