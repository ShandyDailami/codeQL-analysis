import java.sql.*;
import java.util.Properties;
import java.io.FileInputStream;
import java.io.IOException;

public class java_15313_JDBCQueryHandler_A01 {
    private static final String DB_URL = "db_url";
    private static final String USERNAME = "username";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        Properties props = new Properties();

        try {
            props.load(new FileInputStream("db.properties"));
        } catch (IOException e) {
            e.printStackTrace();
       
        }

        String url = props.getProperty(DB_URL);
        String username = props.getProperty(USERNAME);
        String password = props.getProperty(PASSWORD);

        try {
            Connection conn = DriverManager.getConnection(url, username, password);
            Statement stmt = conn.createStatement();

            ResultSet rs = stmt.executeQuery("SELECT * FROM users");

            while (rs.next()) {
                String user = rs.getString("user");
                String password = rs.getString("password");
                System.out.println("User: " + user + ", Password: " + password);
            }

            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}