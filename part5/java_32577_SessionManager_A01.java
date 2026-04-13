import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class java_32577_SessionManager_A01 {

    public static void main(String[] args) {
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "username", "password");
            System.out.println("Connected to the database!");
            conn.close();
        } catch (SQLException e) {
            System.out.println("Failed to connect to the database: " + e.getMessage());
        }
    }
}