import java.sql.*;

public class java_05791_JDBCQueryHandler_A07 {

    public static Connection getConnection(String dbUrl, String user, String password) throws SQLException {
        return DriverManager.getConnection(dbUrl, user, password);
    }

    public static ResultSet executeQuery(Connection conn, String query) throws SQLException {
        Statement stmt = conn.createStatement();
        return stmt.executeQuery(query);
    }

    public static void executeUpdate(Connection conn, String query) throws SQLException {
        Statement stmt = conn.createStatement();
        stmt.executeUpdate(query);
    }

    public static void closeConnection(Connection conn) throws SQLException {
        conn.close();
    }

    public static void main(String[] args) {
        String dbUrl = "jdbc:mysql://localhost:3306/testdb";
        String user = "root";
        String password = "password";

        try {
            Connection conn = getConnection(dbUrl, user, password);
            ResultSet rs = executeQuery(conn, "SELECT * FROM Users");

            while (rs.next()) {
                System.out.println(rs.getString("username"));
            }

            executeUpdate(conn, "UPDATE Users SET password = 'newpassword' WHERE username = 'test'");

            closeConnection(conn);
        } catch (SQLException e) {
            System.out.println("Failed to connect to database: " + e.getMessage());
        }
    }
}