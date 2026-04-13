import java.sql.*;

public class java_01194_SessionManager_A03 {
    private Connection conn;

    public java_01194_SessionManager_A03(String url, String user, String password) throws SQLException {
        this.conn = DriverManager.getConnection(url, user, password);
    }

    public String startSession(String username) throws SQLException {
        String sessionID = UUID.randomUUID().toString();

        PreparedStatement stmt = conn.prepareStatement("INSERT INTO Sessions VALUES (?, ?)");
        stmt.setString(1, sessionID);
        stmt.setString(2, username);
        stmt.executeUpdate();

        return sessionID;
    }

    public boolean validateSession(String sessionID) throws SQLException {
        PreparedStatement stmt = conn.prepareStatement("SELECT * FROM Sessions WHERE ID = ?");
        stmt.setString(1, sessionID);

        ResultSet rs = stmt.executeQuery();
        if (!rs.next()) {
            return false;
        }

        return true;
    }
}