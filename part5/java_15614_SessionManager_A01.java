import java.sql.*;

public class java_15614_SessionManager_A01 {
    private static final String URL = "jdbc:mysql://localhost:3306/testdb";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    private static Connection getConnection() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();
        sessionManager.start();
        sessionManager.stop();
    }

    public static class SessionManager {
        private Connection connection;
        private Statement statement;

        public java_15614_SessionManager_A01() {
            connection = getConnection();
            try {
                statement = connection.createStatement();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        public void start() {
            String sql = "START TRANSACTION; INSERT INTO session (id) VALUES (1); COMMIT;";
            executeSql(sql);
        }

        public void stop() {
            String sql = "START TRANSACTION; DELETE FROM session WHERE id = 1; COMMIT;";
            executeSql(sql);
        }

        private void executeSql(String sql) {
            try {
                statement.executeUpdate(sql);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}