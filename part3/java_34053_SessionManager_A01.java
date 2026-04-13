import java.sql.*;

public class java_34053_SessionManager_A01 {
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/testdb";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    private static Connection connection;
    private static Statement statement;

    static {
        try {
            connection = DriverManager.getConnection(JDBC_URL, USER, PASSWORD);
            statement = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        try {
            // Create a new session
            int sessionId = createSession();

            // Begin a transaction
            beginTransaction(sessionId);

            // Modify user's password
            modifyPassword("user1", "newpassword");

            // Commit the transaction
            commitTransaction(sessionId);

            // Print user's password
            printPassword("user1");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static int createSession() {
        int sessionId = -1;
        try {
            String sql = "INSERT INTO SESSION(CREATED) VALUES (NOW())";
            statement.executeUpdate(sql);
            ResultSet rs = statement.executeQuery("SELECT LAST_INSERT_ID()");
            if (rs.next()) {
                sessionId = rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return sessionId;
    }

    private static void beginTransaction(int sessionId) {
        try {
            String sql = "START TRANSACTION WHERE session_id = " + sessionId;
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void modifyPassword(String username, String newPassword) {
        try {
            String sql = "UPDATE USERS SET PASSWORD = '" + newPassword + "' WHERE USERNAME = '" + username + "'";
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void commitTransaction(int sessionId) {
        try {
            String sql = "COMMIT WHERE session_id = " + sessionId;
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void printPassword(String username) {
        try {
            String sql = "SELECT PASSWORD FROM USERS WHERE USERNAME = '" + username + "'";
            ResultSet rs = statement.executeQuery(sql);
            if (rs.next()) {
                System.out.println(username + "'s password is: " + rs.getString(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}