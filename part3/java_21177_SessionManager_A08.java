import java.sql.*;

public class java_21177_SessionManager_A08 {
    private static final String URL = "jdbc:mysql://localhost:3306/test";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    private static Connection conn;

    public static void main(String[] args) {
        try {
            startSession();
            performIntegrityFailure();
            stopSession();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void startSession() throws SQLException {
        conn = DriverManager.getConnection(URL, USER, PASSWORD);
    }

    private static void performIntegrityFailure() throws SQLException {
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM Employee WHERE IntegrityFailure = TRUE");

        while (rs.next()) {
            String name = rs.getString("Name");
            System.out.println("IntegrityFailure detected for: " + name);
        }
    }

    private static void stopSession() throws SQLException {
        conn.close();
    }
}