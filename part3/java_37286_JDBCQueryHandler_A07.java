import java.sql.*;

public class java_37286_JDBCQueryHandler_A07 {
    private Connection conn;
    private Statement stmt;

    // establish a connection
    public java_37286_JDBCQueryHandler_A07() {
        try {
            conn = DriverManager.getConnection("jdbc:your_database_url", "username", "password");
            stmt = conn.createStatement();
        } catch (SQLException e) {
            System.out.println("Connection Failed! Check output console");
            e.printStackTrace();
        }
    }

    // execute an SQL query
    public ResultSet executeQuery(String query) {
        try {
            return stmt.executeQuery(query);
        } catch (SQLException e) {
            System.out.println("Error executing query " + query);
            e.printStackTrace();
       
        }
        return null;
    }

    // execute an SQL update (insert, update, delete)
    public void executeUpdate(String query) {
        try {
            stmt.executeUpdate(query);
        } catch (SQLException e) {
            System.out.println("Error executing update " + query);
            e.printStackTrace();
        }
    }

    // close the connection
    public void close() {
        try {
            if (stmt != null) stmt.close();
            if (conn != null) conn.close();
        } catch (SQLException e) {
            System.out.println("Error closing connections");
            e.printStackTrace();
        }
    }
}