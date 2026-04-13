import java.sql.*;

public class java_01022_JDBCQueryHandler_A01 {
    private static final String URL = "jdbc:your_db_url";
    private static final String USER = "username";
    private static final String PASS = "password";

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASS);
    }

    public void query(String query, String permission,
                      Callback callback) throws SQLException {
        Connection connection = null;
        PreparedStatement pstmt = null;

        try {
            connection = getConnection();
            pstmt = connection.prepareStatement(query);

            // Check if the user has the required permission
            if (!checkPermission(permission, connection)) {
                throw new SecurityException("Insufficient permissions");
            }

            callback.process(pstmt.executeQuery());
        } finally {
            if (pstmt != null) pstmt.close();
            if (connection != null) connection.close();
        }
    }

    private boolean checkPermission(String permission, Connection connection) throws SQLException {
        // Implementation depends on your database. Here I'm using a dummy method
        // that just returns true for all permissions.
        return true;
    }

    public interface Callback {
        void process(ResultSet resultSet) throws SQLException;
    }
}