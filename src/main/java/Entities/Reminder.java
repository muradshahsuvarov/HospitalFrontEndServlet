package Entities;

import java.time.LocalDateTime;

public class Reminder {

    public Integer reminderId;
    public Integer bookId;
    public Boolean reminderIsEnabled;
    public Boolean notificationIsSent;
    public LocalDateTime datetime;
    public String reminderEmail;

    public Reminder(Integer _reminderId,
                    Integer _bookId,
                    Boolean _reminderIsEnabled,
                    Boolean _notificationIsSent,
                    LocalDateTime _dateTime,
                    String _reminderEmail) {
        this.reminderId = _reminderId;
        this.bookId = _bookId;
        this.reminderIsEnabled = _reminderIsEnabled;
        this.notificationIsSent = _notificationIsSent;
        this.datetime = _dateTime;
        this.reminderEmail = _reminderEmail;
    }

    public LocalDateTime getDatetime() { return this.datetime; }
    public Boolean getReminderIsEnabled() { return this.reminderIsEnabled; }
    public Boolean getNotificationIsSet() { return this.notificationIsSent; }
    public void setDatetime(LocalDateTime _datetime) { this.datetime = _datetime; }
    public void enableReminder() { reminderIsEnabled = true; }
    public void setNotification(Boolean _notificationIsSent) {  this.notificationIsSent = _notificationIsSent; }


    public void print() { }
}
