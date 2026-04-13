import java.sql.*;

public class java_37173_SessionManager_A03 {
    // Database credentials
    private static final String DB_USERNAME = "root";
    private static final String DB_PASSWORD = "password";
    private static final String DB_URL = "jdbc:mysql://localhost:3306/testdb";

    // Method to create a connection
    private Connection createConnection() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    // Method to open a session
    public Session openSession() {
        return new Session(createConnection());
    }

    // Session class
    public static class Session {
        private Connection conn;

        public java_37173_SessionManager_A03(Connection conn) {
            this.conn = conn;
        }

        // Method to perform a database operation
        public void performDBOperation(String query) {
            try (Statement stmt = conn.createStatement()) {
                ResultSet rs = stmt.executeQuery(query)) {
                    while (rs.next()) {
                        // Perform security-sensitive operation here
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        // Method to close the session
        public void closeSession() {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        SessionManager sm = new SessionManager();
        Session session = sm.openSession();
        session.performDBOperation("SELECT * FROM Users"); // Replace with actual query
        session.closeSession();
    }
}