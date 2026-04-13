import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Session;
import java.sql.SQLException;

public class java_29317_SessionManager_A03 {

    // This is the in-memory database for the example
    private static String DATABASE_URL = "jdbc:mem:testdb";
    private static String USERNAME = "test";
    private static String PASSWORD = "test";

    // Initialize the database
    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // MySQL database driver
            DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public Session openSession() {
        try {
            Connection connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
            return connection.newSession();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void closeSession(Session session) {
        if (session != null) {
            try {
                session.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();
        Session session = sessionManager.openSession();

        // Insert a row into the table
        session.insert("INSERT INTO USERS(ID, NAME) VALUES(1, 'John')");

        // Fetch the inserted row
        session.select("SELECT * FROM USERS WHERE ID = 1");

        sessionManager.closeSession(session);
    }
}