import java.sql.*;

public class java_37914_SessionManager_A08 {
    private Connection connection;

    public java_37914_SessionManager_A08(String url, String username, String password) throws SQLException {
        this.connection = DriverManager.getConnection(url, username, password);
    }

    public Session openSession() throws SQLException {
        return connection.newSession();
    }

    public void closeSession(Session session) throws SQLException {
        session.close();
    }

    public void main(String[] args) {
        try {
            SessionManager sm = new SessionManager("jdbc:mysql://localhost/test", "username", "password");
            Session session = sm.openSession();

            // Perform integrity-sensitive operations here...

            sm.closeSession(session);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}