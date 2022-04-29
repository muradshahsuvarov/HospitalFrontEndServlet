package Entities;

public class Feedback {

    public Integer feedbackId;
    public Doctor doctor;
    public String description;

    public Feedback() { }

    public String getDescription() { return this.description; }
    public void setDescription(String _feedback) { this.description = _feedback; }
    public void viewFeedback() { }
}
