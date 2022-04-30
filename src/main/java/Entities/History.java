package Entities;

import java.time.LocalDateTime;

public class History {

    public Integer historyId;
    public String email;
    public String description;
    public LocalDateTime dateTime;

    public History(
            Integer _historyId,
            String _email,
            String _description,
            LocalDateTime _dateTime
    ) {
        this.historyId = _historyId;
        this.email = _email;
        this.description = _description;
        this.dateTime = _dateTime;
    }


    public void print() { }
}
