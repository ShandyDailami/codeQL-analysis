import java.sql.*;

public class java_13918_JDBCQueryHandler_A01 {
    // private fields
    private Connection conn;
    private Statement stmt;

    // constructor
    public java_13918_JDBCQueryHandler_A01(String url, String username, String password) {
        try {
            // Create a connection
            this.conn = DriverManager.getConnection(url, username, password);
            // Create a statement
            this.stmt = conn.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // execute query method
    public void executeQuery(String query) {
        try {
            // Execute the query
            ResultSet rs = stmt.executeQuery(query);
            // Handle the ResultSet
            while (rs.next()) {
                System.out.println(rs.getString("columnName"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // close method
    public void close() {
        try {
            // Close the statement and connection
            this.stmt.close();
            this.conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}