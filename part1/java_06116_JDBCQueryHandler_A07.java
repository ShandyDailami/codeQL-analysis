import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class java_06116_JDBCQueryHandler_A07 {

    private static final String DB_URL = "jdbc:mysql://localhost:3306/mydb";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            if (connection != null) {
                System.out.println("Connected to the database");
            }
        } catch (SQLException e) {
            System.out.println("Failed to connect to the database");
            e.printStackTrace();
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                    System.out.println("Closed the connection");
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}