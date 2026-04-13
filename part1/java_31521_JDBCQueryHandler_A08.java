import java.sql.*;

public class java_31521_JDBCQueryHandler_A08 {

    private Connection conn = null;

    // Establish a connection with the database
    public Connection establishConnection(String dbURL, String username, String password) throws SQLException {
        this.conn = DriverManager.getConnection(dbURL, username, password);
        return this.conn;
    }

    // Perform a SELECT operation
    public ResultSet executeQuery(String query) throws SQLException {
        Statement stmt = this.conn.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        return rs;
    }

    // Perform an UPDATE operation
    public int executeUpdate(String query) throws SQLException {
        Statement stmt = this.conn.createStatement();
        int res = stmt.executeUpdate(query);
        return res;
    }

    // Perform a DELETE operation
    public int executeDelete(String query) throws SQLException {
        Statement stmt = this.conn.createStatement();
        int res = stmt.executeUpdate(query);
        return res;
    }

    // Close the database connection
    public void closeConnection() throws SQLException {
        this.conn.close();
    }
}