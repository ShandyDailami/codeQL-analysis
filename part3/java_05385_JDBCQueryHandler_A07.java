import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class java_05385_JDBCQueryHandler_A07 {
    private static final String URL = "jdbc:mysql://localhost:3306/mydb";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            if (conn != null) {
                System.out.println("Connected successfully to database!");
            } else {
                System.out.println("Failed to connect to database!");
            }
        } catch (SQLException e) {
            System.out.println("Error while connecting to database!");
            e.printStackTrace();
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}