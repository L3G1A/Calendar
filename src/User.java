import java.sql.*;

public class User {
    String username;
    String password;
    String userID;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }




    public String authnticateUser() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://freezersports.com:3306/freezers_project", "freezers_root", "test123");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from users WHERE username = \"" + username + "\";");
            ResultSetMetaData rsmd = rs.getMetaData();
            int columnsNumber = rsmd.getColumnCount();
            while (rs.next()) {

                String correctPassword = rs.getString(3);
                if(correctPassword.equals(password)){
                    return("OK");
                }
                else{
                    return("No");
                }
            }
            con.close();
        } catch (Exception e) {
            System.out.println("Cannot Connect to server, showing data from last session online");
        }

        return "Con";
    }


    public void getUserId(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://freezersports.com:3306/freezers_project", "freezers_root", "test123");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from users WHERE username = \"" + username + "\";");
            ResultSetMetaData rsmd = rs.getMetaData();
            int columnsNumber = rsmd.getColumnCount();
            while (rs.next()) {

                String userID = rs.getString(1);
                this.userID = userID;

            }
            con.close();
        } catch (Exception e) {
            System.out.println("Cannot Connect to server, showing data from last session online");
        }

    }
}



