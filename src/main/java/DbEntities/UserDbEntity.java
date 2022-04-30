package DbEntities;

import Entities.User;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class UserDbEntity extends DbEntity{

    List<User> users;

    public  UserDbEntity(){

        users = new ArrayList<User>();

        String line = "";

        try {
            BufferedReader br = new BufferedReader(new FileReader("users.csv"));
            long row_number = 0;
            while((line = br.readLine()) != null){
                if (row_number >= 1) {

                    String[] item_row = line.split(";");
                    User row_user = new User(item_row[1],
                            item_row[2],
                            item_row[3],
                            item_row[4],
                            item_row[5],
                            item_row[6],
                            Integer.parseInt(item_row[7]),
                            item_row[8],
                            Boolean.valueOf(item_row[9]),
                            item_row[10]);

                    users.add(row_user);
                }
                row_number++;
            }
        }catch(Exception e) {
            System.out.println(e);
        }

    }

    @Override
    public void PrintData() {
        for (var item : users) {
            item.print();
        }
    }

    public List<User> GetData(){
        return this.users;
    }

    @Override
    public Boolean DeleteData(String _key) {
        try{
            User _tmpUser = null;
            System.out.println("users.size(): " + users.size());
            for (var user : users) {
                System.out.println("Key: " + _key + ", user.email: " + user.getEmail());
                if (user.getEmail().equals(_key)) {
                    _tmpUser = user;
                    break;
                }
            }

            users.remove(_tmpUser);
            CreateTable();

            for (var _user : users) {

                StringBuilder _userAccount = new StringBuilder();

                long lineCount_users;
                try (Stream<String> stream = Files.lines(Path.of("users.csv"), StandardCharsets.UTF_8)) {
                    lineCount_users = stream.count();
                }

                _userAccount.append(lineCount_users - 1);
                _userAccount.append(";");
                _userAccount.append(_user.getName());
                _userAccount.append(";");
                _userAccount.append(_user.getSurname());
                _userAccount.append(";");
                _userAccount.append(_user.getUsername());
                _userAccount.append(";");
                _userAccount.append(_user.getEmail());
                _userAccount.append(";");
                _userAccount.append(_user.getPassword());
                _userAccount.append(";");
                _userAccount.append(_user.getPhone());
                _userAccount.append(";");
                _userAccount.append(_user.getAge());
                _userAccount.append(";");
                _userAccount.append(_user.getGender());
                _userAccount.append(";");
                _userAccount.append(_user.getIsDoctor());
                _userAccount.append(";");
                _userAccount.append(_user.getPersonalInfo());


                Boolean user_registration_step = AddRow(_userAccount);


            }


            System.out.println("User " + _tmpUser.getEmail() + " has been successfully deleted!");
            return true;
        }catch (Exception e){
            System.out.println("User deletion failed!");
            System.out.println("Reason: " + e.toString());
            return false;
        }
    }

    @Override
    public void CreateTable(){
        super.CreateTable();
        try (PrintWriter writer = new PrintWriter("users.csv")) {

            StringBuilder sb = new StringBuilder();
            sb.append("Id");
            sb.append(';');
            sb.append("Name");
            sb.append(';');
            sb.append("Surname");
            sb.append(";");
            sb.append("Username");
            sb.append(";");
            sb.append("Email");
            sb.append(";");
            sb.append("Password");
            sb.append(";");
            sb.append("Phone");
            sb.append(";");
            sb.append("Age");
            sb.append(";");
            sb.append("Gender");
            sb.append(";");
            sb.append("isDoctor");
            sb.append(";");
            sb.append("personalInfo");
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

        FileWriter  fw = new FileWriter("users.csv", true);
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
