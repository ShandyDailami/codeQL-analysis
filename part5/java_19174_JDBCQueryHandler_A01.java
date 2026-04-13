import java.sql.*;

public class java_19174_JDBCQueryHandler_A01 {

    // Assume we have a database connection
    private Connection conn;

    public java_19174_JDBCQueryHandler_A01(Connection conn) {
        this.conn = conn;
    }

    // A method to perform a query
    public ResultSet executeQuery(String query) {
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            return rs;
        } catch (SQLException e) {
            System.out.println("Error executing query: " + e.getMessage());
            return null;
        }
    }

    // A method to perform an update
    public int executeUpdate(String query) {
        try {
            Statement stmt = conn.createStatement();
            return stmt.executeUpdate(query);
        } catch (SQLException e) {
            System.out.println("Error executing update: " + e.getMessage());
            return -1;
        }
    }

    // A method to close the connection
    public void closeConnection() {
        try {
            if (conn != null && !conn.isClosed()) {
                conn.close();
            }
        } catch (SQLException e) {
            System.out.println("Error closing connection: " + e.getMessage());
        }
    }
}