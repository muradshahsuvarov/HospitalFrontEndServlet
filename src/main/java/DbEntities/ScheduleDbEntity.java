package DbEntities;

import Entities.Schedule;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ScheduleDbEntity extends DbEntity{


    public List<Schedule> schedules;

    public ScheduleDbEntity() {

        schedules = new ArrayList<Schedule>();



        String line = "";

        try {
            BufferedReader br = new BufferedReader(new FileReader("schedules.csv"));
            long row_number = 0;
            while((line = br.readLine()) != null){
                if (row_number >= 1) {

                    String[] item_row = line.split(";");

                    Schedule row_schedule = new Schedule(
                            Integer.parseInt(item_row[0]),
                            item_row[1]);

                    schedules.add(row_schedule);

                }
                row_number++;
            }
        }catch(Exception e) {
            System.out.println(e);
        }

    }

    @Override
    public void PrintData() {
        for (var item : schedules) {
            item.print();
        }
    }

    public List<Schedule> GetData(){
        return this.schedules;
    }


    @Override
    public Boolean DeleteData(String _key) {
        try{
            Schedule _tmpSchedule = null;
            System.out.println("schelues.size(): " + schedules.size());
            for (var schedule : schedules) {
                System.out.println("Key: " + _key + ", schedule.scheduleId: " + schedule.scheduleId);
                if (schedule.scheduleId == Integer.parseInt(_key)) {
                    _tmpSchedule = schedule;
                    break;
                }
            }

            schedules.remove(_tmpSchedule);
            CreateTable();

            for (var schedule : schedules) {

                StringBuilder schedule_sb = new StringBuilder();

                schedule_sb.append(schedule.scheduleId);
                schedule_sb.append(';');
                schedule_sb.append(schedule.ownerEmail);

                Boolean hospital_registration_step = AddRow(schedule_sb);
            }


            System.out.println("Hospital " + _tmpSchedule.scheduleId + " has been successfully deleted!");
            return true;
        }catch (Exception e){
            System.out.println("User deletion failed!");
            System.out.println("Reason: " + e.toString());
            return false;
        }
    }

    public void CreateTable() {
        try (PrintWriter writer = new PrintWriter("schedules.csv")) {

            StringBuilder sb = new StringBuilder();
            sb.append("ScheduleId");
            sb.append(';');
            sb.append("OwnerEmail");
            sb.append('\n');
            writer.write(sb.toString());

            System.out.println("Table has been successfully created!");


        } catch (FileNotFoundException e) {
            System.out.println("Table Creation Failed, Reason: " + e.getMessage());
        }
    }

    @Override
    public Boolean AddRow(StringBuilder _row) throws IOException {

        super.AddRow(_row);

        FileWriter  fw = new FileWriter("schedules.csv", true);
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
