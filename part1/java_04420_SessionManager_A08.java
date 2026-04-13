import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class java_04420_SessionManager_A08 {
    private static final String URL = "jdbc:mysql://localhost:3306/mydatabase";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    private static ThreadLocal<Connection> connectionHolder = new ThreadLocal<Connection>() {
        protected Connection initialValue() {
            Connection conn = null;
            try {
                conn = DriverManager.getConnection(URL, USER, PASSWORD);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return conn;
        }
    };

    public static Connection getConnection() {
        return connectionHolder.get();
    }

    public static void main(String[] args) {
        Connection conn = getConnection();
        try {
            conn.createStatement().execute("select * from users");
        } catch (SQLException e) {
            System.out.println("Unable to access the database");
        }
        conn.close();
    }
}