import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class java_24033_SessionManager_A01 {

    private static final String DB_URL = "jdbc:mysql://localhost:3306/mydb";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "password";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
    }

    public static void main(String[] args) throws SQLException {
        Connection conn = getConnection();
        System.out.println("Connection successful!");
        conn.close();
    }
}