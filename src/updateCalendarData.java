import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

public class updateCalendarData {


    public static void update(String userID) throws FileNotFoundException, UnsupportedEncodingException {
        ArrayList<String> userAcitivityData = new ArrayList<>();

        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con= DriverManager.getConnection(
                    "jdbc:mysql://freezersports.com:3306/freezers_project","freezers_root","test123");
            Statement stmt=con.createStatement();
            ResultSet rs=stmt.executeQuery("select * from activities WHERE users_ID = \"" + userID +  "\";" );
            System.out.println("Downloading Data..........");
            ResultSetMetaData rsmd = rs.getMetaData();
            int columnsNumber = rsmd.getColumnCount();
            while (rs.next()) {
                String line = "";

                for (int i = 1; i <= columnsNumber; i++) {
                    String columnValue = rs.getString(i);
                    line += columnValue + ",";
                }
                userAcitivityData.add(line);
            }
            con.close();
        }catch(Exception e){ System.out.println("Cannot Connect to server, showing data from last session online");}

        PrintWriter writer = new PrintWriter("activities.data", "UTF-8");
        for(int i = 0; i < userAcitivityData.size(); i ++){
            writer.println(userAcitivityData.get(i));
        }

        writer.close();


    }

    public static ArrayList getDayData(String Month, String Day, String Year){
        ArrayList<String> matchingData = new ArrayList<>();

        try (Scanner inFile1 = new Scanner(new File("activities.data"))) {

            ArrayList<String> allUserData = new ArrayList<>();
            while (inFile1.hasNext()) {
                allUserData.add(inFile1.nextLine());
            }

            for(int i = 0; i < allUserData.size(); i ++) {

                String[] dataSep = allUserData.get(i).split(",");
                if (dataSep[7].equals(Month) && dataSep[8].equals(Day) && dataSep[9].equals(Year)) {
                    matchingData.add(allUserData.get(i));
                    System.out.println(allUserData.get(i));

                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }



        return matchingData;
    }


}
