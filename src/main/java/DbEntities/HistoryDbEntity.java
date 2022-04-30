package DbEntities;

import Entities.History;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class HistoryDbEntity extends DbEntity{


    List<History> history;


    public HistoryDbEntity() {

        history = new ArrayList<History>();

        String line = "";

        try {
            BufferedReader br = new BufferedReader(new FileReader("history.csv"));
            long row_number = 0;
            while((line = br.readLine()) != null){
                if (row_number >= 1) {

                    String[] item_row = line.split(";");

                    History row_history = new History(
                            Integer.parseInt(item_row[0]),
                            item_row[1],
                            item_row[2],
                            LocalDateTime.parse(item_row[3], DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"))
                            );

                    history.add(row_history);

                }
                row_number++;
            }
        }catch(Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public void PrintData() {
        for (var item : history) {
            item.print();
        }
    }


    public List<History> GetData(){
        return this.history;
    }

    @Override
    public Boolean DeleteData(String _key) {
        try{
            History _tmpHistory = null;
            System.out.println("history.size(): " + history.size());
            for (var historyItem : history) {
                System.out.println("Key: " + _key + ", hospital.hospitalId: " + historyItem.historyId);
                if (historyItem.historyId == Integer.parseInt(_key)) {
                    _tmpHistory = historyItem;
                    break;
                }
            }

            history.remove(_tmpHistory);
            CreateTable();

            for (var historyItem : history) {

                StringBuilder history_sb = new StringBuilder();

                long lineCount_users;
                try (Stream<String> stream = Files.lines(Path.of("history.csv"), StandardCharsets.UTF_8)) {
                    lineCount_users = stream.count();
                }

                history_sb.append(lineCount_users - 1);
                history_sb.append(';');
                history_sb.append(historyItem.email);
                history_sb.append(';');
                history_sb.append(historyItem.description);
                history_sb.append(';');
                history_sb.append(historyItem.dateTime);

                Boolean hospital_registration_step = AddRow(history_sb);
            }


            System.out.println("Hospital " + _tmpHistory.description + " has been successfully deleted!");
            return true;
        }catch (Exception e){
            System.out.println("User deletion failed!");
            System.out.println("Reason: " + e.toString());
            return false;
        }
    }

    public void CreateTable() {
        try (PrintWriter writer = new PrintWriter("history.csv")) {

            StringBuilder sb = new StringBuilder();
            sb.append("HistoryId");
            sb.append(';');
            sb.append("Email");
            sb.append(';');
            sb.append("Description");
            sb.append(';');
            sb.append("DateTime");
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

        FileWriter  fw = new FileWriter("hospitals.csv", true);
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
