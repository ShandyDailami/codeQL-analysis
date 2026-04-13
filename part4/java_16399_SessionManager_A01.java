import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class java_16399_SessionManager_A01 {

    private List<Session> sessions;

    public java_16399_SessionManager_A01() {
        sessions = new ArrayList<>();
    }

    public Session createSession() {
        Session session = new Session();
        sessions.add(session);
        return session;
    }

    public void performQuery(Session session, String query) {
        try {
            PreparedStatement pstmt = session.getConnection().prepareStatement(query);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                System.out.println(rs.getString(1));
            }

            session.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static class Session {

        private Connection connection;

        public Connection getConnection() {
            try {
                connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb", "username", "password");
                return connection;
            } catch (SQLException e) {
                e.printStackTrace();
                return null;
            }
        }

        public void close() {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}