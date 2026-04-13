import java.sql.*;

public class java_01449_SessionManager_A08 {

    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/testdb";
    private static final String USERNAME = "username";
    private static final String PASSWORD = "password";

    private static SessionManager instance = null;

    private java_01449_SessionManager_A08() {
        // private constructor to restrict instantiation from outside
    }

    public static SessionManager getInstance() {
        if (instance == null) {
            instance = new SessionManager();
        }
        return instance;
    }

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
    }

    public PreparedStatement createPreparedStatement(Connection connection, String sql) throws SQLException {
        return connection.prepareStatement(sql);
    }

    public void close(Connection connection, PreparedStatement statement) {
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        SessionManager sm = SessionManager.getInstance();

        try {
            Connection conn = sm.getConnection();
            String sql = "SELECT * FROM users WHERE username = ?";
            PreparedStatement stmt = sm.createPreparedStatement(conn, sql);
            stmt.setString(1, "testUser");

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                System.out.println(rs.getString("password"));
            }

            sm.close(conn, stmt);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}