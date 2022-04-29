package Entities;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Reminder {

    public Book book;
    public LocalDateTime datetime;
    public Boolean reminderIsEnabled;
    public Boolean notificationIsSent;

    public Reminder() { }

    public LocalDateTime getDatetime() { return this.datetime; }
    public Boolean getReminderIsEnabled() { return this.reminderIsEnabled; }
    public Boolean getNotificationIsSet() { return this.notificationIsSent; }
    public void setDatetime(LocalDateTime _datetime) { this.datetime = _datetime; }
    public void enableReminder() { reminderIsEnabled = true; }
    public void setNotification(Boolean _notificationIsSent) {  this.notificationIsSent = _notificationIsSent; }

}
