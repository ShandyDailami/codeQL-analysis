import java.sql.*;

public class java_35105_JDBCQueryHandler_A08 {
    // Connection to the database
    private Connection conn = null;

    public void connect(String url, String username, String password) {
        try {
            // Load the driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Open a connection
            this.conn = DriverManager.getConnection(url, username, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void executeQuery(String query) {
        try {
            // Prepare the statement
            Statement stmt = conn.createStatement();

            // Execute the query
            ResultSet rs = stmt.executeQuery(query);

            // Handle the query result
            while (rs.next()) {
                System.out.println(rs.getString("name"));
            }

            rs.close();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void closeConnection() {
        try {
            // Close the connection
            if (conn != null && !conn.isClosed()) {
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}