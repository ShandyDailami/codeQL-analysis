import java.sql.*;
import java.util.Properties;

public class java_14419_JDBCQueryHandler_A08 {
    // Define database parameters
    private static final String USERNAME = "username";
    private static final String PASSWORD = "password";
    private static final String URL = "jdbc:mysql://localhost:3306/mydatabase";
    private static final String DRIVER = "com.mysql.jdbc.Driver";

    // Open a connection to the database
    public Connection openConnection() throws SQLException {
        Properties props = new Properties();
        props.setProperty("user", USERNAME);
        props.setProperty("password", PASSWORD);
        props.setProperty("characterEncoding", "utf8");
        Class.forName(DRIVER);
        return DriverManager.getConnection(URL, props);
    }

    // Close a connection to the database
    public void closeConnection(Connection conn) {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    // Execute a query on the database
    public ResultSet executeQuery(Connection conn, String query) {
        ResultSet rs = null;
        PreparedStatement pstmt = null;
        try {
            pstmt = conn.prepareStatement(query);
            rs = pstmt.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }

    // Execute a statement on the database (update, insert, delete)
    public int executeUpdate(Connection conn, String query) {
        int result = 0;
        PreparedStatement pstmt = null;
        try {
            pstmt = conn.prepareStatement(query);
            result = pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
}