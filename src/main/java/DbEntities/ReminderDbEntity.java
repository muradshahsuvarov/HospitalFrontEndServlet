package DbEntities;

import Entities.Reminder;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class ReminderDbEntity extends  DbEntity{

    List<Reminder> reminders;

    public ReminderDbEntity() {

        reminders = new ArrayList<Reminder>();

        String line = "";

        try {
            BufferedReader br = new BufferedReader(new FileReader("reminders.csv"));
            long row_number = 0;
            while((line = br.readLine()) != null){
                if (row_number >= 1) {

                    String[] item_row = line.split(";");

                    Reminder row_reminder = new Reminder(
                            Integer.parseInt(item_row[0]),
                            Integer.parseInt(item_row[1]),
                            Boolean.valueOf(item_row[2]),
                            Boolean.valueOf(item_row[3]),
                            LocalDateTime.parse(item_row[4], DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")),
                            item_row[5]
                    );

                    reminders.add(row_reminder);

                }
                row_number++;
            }
        }catch(Exception e) {
            System.out.println(e);
        }

    }


    @Override
    public void PrintData() {
        for (var item : reminders) {
            item.print();
        }
    }

    public List<Reminder> GetData(){
        return this.reminders;
    }


    @Override
    public Boolean DeleteData(String _key) {
        try{
            Reminder _tmpReminder = null;
            System.out.println("reminders.size(): " + reminders.size());
            for (var reminder : reminders) {
                System.out.println("Key: " + _key + ", reminder.hospitalId: " + reminder.reminderId);
                if (reminder.reminderId == Integer.parseInt(_key)) {
                    _tmpReminder = reminder;
                    break;
                }
            }

            reminders.remove(_tmpReminder);
            CreateTable();

            for (var reminder : reminders) {

                StringBuilder reminder_sb = new StringBuilder();

                long lineCount_users;
                try (Stream<String> stream = Files.lines(Path.of("reminders.csv"), StandardCharsets.UTF_8)) {
                    lineCount_users = stream.count();
                }

                reminder_sb.append(lineCount_users - 1);
                reminder_sb.append(';');
                reminder_sb.append(reminder.bookId);
                reminder_sb.append(";");
                reminder_sb.append(reminder.reminderIsEnabled);
                reminder_sb.append(";");
                reminder_sb.append(reminder.notificationIsSent);
                reminder_sb.append(';');
                reminder_sb.append(reminder.datetime);
                reminder_sb.append(';');
                reminder_sb.append(reminder.reminderEmail);

                Boolean reminder_registration_step = AddRow(reminder_sb);
            }


            System.out.println("Hospital " + _tmpReminder.reminderId + " has been successfully deleted!");
            return true;
        }catch (Exception e){
            System.out.println("User deletion failed!");
            System.out.println("Reason: " + e.toString());
            return false;
        }
    }

    public void CreateTable() {

        try (PrintWriter writer = new PrintWriter("reminders.csv")) {

            StringBuilder sb = new StringBuilder();
            sb.append("ReminderId");
            sb.append(';');
            sb.append("BookId");
            sb.append(";");
            sb.append("ReminderIsEnabled");
            sb.append(";");
            sb.append("NotificationIsSent");
            sb.append(';');
            sb.append("DateTime");
            sb.append(';');
            sb.append("ReminderEmail");
            sb.append('\n');
            //sb.append(<User Data>)
            writer.write(sb.toString());

            System.out.println("Table has been successfully created!");


        } catch (FileNotFoundException e) {
            System.out.println("Table Creation Failed, Reason: " + e.getMessage());
        }

    }

    @Override
    public Boolean AddRow(StringBuilder _row) throws IOException {

        super.AddRow(_row);

        FileWriter  fw = new FileWriter("reminders.csv", true);
        BufferedWriter bw = new BufferedWriter(fw);

        try (PrintWriter writer = new PrintWriter(bw)) {


            writer.println(_row.toString());

            System.out.println("Table has been successfully created!");

            writer.flush();
            return true;
        }catch(Exception e){
            return false;
        }
    }
}
