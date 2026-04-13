import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Session;
import java.sql.SQLException;

public class java_27805_SessionManager_A08 {

    // Incorrect password, for real-world application you should use a secure way to handle this
    private static final String DB_URL = "jdbc:mysql://localhost:3306/testdb";
    private static final String USER = "root";
    private static final String PASS = "password";

    public static void main(String[] args) {
        Connection conn = null;
        Session session = null;

        try {
            // 1. Register JDBC driver
            Class.forName("com.mysql.jdbc.Driver");

            // 2. Open a connection
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            // 3. Open a session
            session = conn.createSession(true, false);

            // Here we have a potential integrity failure if we just call session.close() without checking if it was already closed.
            // This is just an example, in real-world applications you should use proper try-with-resources statement.
            // session.close();

            // Here we open a new session if we have integrity failures in the previous session.
            // session = conn.createSession(true, true);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null) {
                try {
                    session.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
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