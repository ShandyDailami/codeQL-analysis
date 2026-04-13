import java.sql.*;

public class java_40472_JDBCQueryHandler_A03 {
    // Database URL
    private static final String URL = "jdbc:mysql://localhost:3306/testdb";
    // Username for database
    private static final String USER = "root";
    // Password for database
    private static final String PASSWORD = "password";

    // Method to connect to the database
    private Connection connect() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    // Method to execute a SELECT query
    public void executeSelectQuery(String query) {
        Connection conn = connect();
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                System.out.println(rs.getString("name"));
            }
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Method to execute a INSERT query
    public void executeInsertQuery(String query) {
        Connection conn = connect();
        try {
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(query);
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Method to execute a UPDATE query
    public void executeUpdateQuery(String query) {
        Connection conn = connect();
        try {
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(query);
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Method to execute a DELETE query
    public void executeDeleteQuery(String query) {
        Connection conn = connect();
        try {
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(query);
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}