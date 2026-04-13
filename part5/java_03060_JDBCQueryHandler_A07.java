import java.sql.*;

public class java_03060_JDBCQueryHandler_A07 {
    private Connection conn;

    public java_03060_JDBCQueryHandler_A07(String url, String username, String password) throws SQLException {
        this.conn = DriverManager.getConnection(url, username, password);
    }

    public ResultSet executeQuery(String query) throws SQLException {
        Statement stmt = conn.createStatement();
        return stmt.executeQuery(query);
    }

    public void closeConnection() throws SQLException {
        conn.close();
    }

    public static void main(String[] args) {
        try {
            String url = "jdbc:mysql://localhost:3306/mydatabase";
            String username = "username";
            String password = "password";

            // Step 1: Connect to the database
            JDBCQueryHandler handler = new JDBCQueryHandler(url, username, password);

            // Step 2: Execute a query
            ResultSet rs = handler.executeQuery("SELECT * FROM my_table");

            // Step 3: Handle the results
            while (rs.next()) {
                // Process each row
                String column1 = rs.getString("column1");
                // Continue processing...

                // Step 4: Close the connection
                handler.closeConnection();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}