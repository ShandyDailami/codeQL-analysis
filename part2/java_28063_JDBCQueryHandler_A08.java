import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class java_28063_JDBCQueryHandler_A08 {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/test";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    private static Connection connection;

    static {
        try {
            connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
            System.exit(-1);
        }
    }

    public static Connection getConnection() {
        return connection;
    }

    public static void main(String[] args) {
        try {
            if (connection != null && !connection.isClosed()) {
                System.out.println("Connection successful!");
            } else {
                System.out.println("Connection not successful!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}