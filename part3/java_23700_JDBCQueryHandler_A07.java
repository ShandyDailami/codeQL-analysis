import java.sql.*;

public class java_23700_JDBCQueryHandler_A07 {
    private static final String JDBC_URL = "your_database_url";
    private static final String USER = "your_username";
    private static final String PASSWORD = "your_password";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(JDBC_URL, USER, PASSWORD);
    }

    public static ResultSet executeQuery(String query) throws SQLException {
        Connection conn = getConnection();
        Statement stmt = conn.createStatement();
        return stmt.executeQuery(query);
    }

    public static void executeUpdate(String query) throws SQLException {
        Connection conn = getConnection();
        Statement stmt = conn.createStatement();
        stmt.executeUpdate(query);
    }

    public static void closeConnection(Connection conn) throws SQLException {
        conn.close();
    }

    public static void main(String[] args) {
        String query = "SELECT * FROM your_table";
        try {
            ResultSet rs = executeQuery(query);
            while (rs.next()) {
                System.out.println(rs.getString("your_column"));
            }
            closeConnection(getConnection());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}