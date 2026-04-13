import java.sql.*;

public class java_01005_SessionManager_A03 {

    private static final String URL = "jdbc:mysql://localhost:3306/testdb";
    private static final String USER = "root";
    private static final String PASS = "password";

    private Connection connection;

    public java_01005_SessionManager_A03() {
        try {
            this.connection = DriverManager.getConnection(URL, USER, PASS);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void storeSession(String sessionId, String sessionData) {
        try {
            String query = "INSERT INTO SESSION(sessionId, sessionData) VALUES(?, ?)";
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setString(1, sessionId);
            stmt.setString(2, sessionData);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public String recoverSession(String sessionId) {
        try {
            String query = "SELECT sessionData FROM SESSION WHERE sessionId = ?";
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setString(1, sessionId);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return rs.getString("sessionData");
            } else {
                return null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void closeSession(String sessionId) {
        try {
            String query = "DELETE FROM SESSION WHERE sessionId = ?";
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setString(1, sessionId);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SecureSessionManager sessionManager = new SecureSessionManager();

        // Store session
        sessionManager.storeSession("session1", "sessionData1");

        // Retrieve session
        String sessionData = sessionManager.recoverSession("session1");
        System.out.println("Retrieved session data: " + sessionData);

        // Close session
        sessionManager.closeSession("session1");
    }
}