import java.sql.*;
import java.util.Properties;

public class java_10299_JDBCQueryHandler_A07 {
    private Connection conn = null;
    private Statement stmt = null;

    // Method to connect to database
    public void connect(String url, Properties props) throws SQLException {
        conn = DriverManager.getConnection(url, props);
        stmt = conn.createStatement();
    }

    // Method to execute a SELECT query
    public ResultSet executeSelectQuery(String query) throws SQLException {
        return stmt.executeQuery(query);
    }

    // Method to execute a DELETE, UPDATE, INSERT or any other SQL command
    public int executeUpdate(String query) throws SQLException {
        return stmt.executeUpdate(query);
    }

    // Method to disconnect from database
    public void disconnect() throws SQLException {
        if (stmt != null) stmt.close();
        if (conn != null) conn.close();
    }

    public static void main(String[] args) {
        // Create a new JDBCQueryHandler
        JDBCQueryHandler handler = new JDBCQueryHandler();

        // Connect to the database
        Properties props = new Properties();
        props.setProperty("user", "username");
        props.setProperty("password", "password");
        try {
            handler.connect("jdbc:mysql://localhost:3306/mydb", props);

            // Execute a SELECT query
            ResultSet rs = handler.executeSelectQuery("SELECT * FROM mytable");

            // Process the result set
            while (rs.next()) {
                // Print out the data from each row
                System.out.println("ID: " + rs.getString("ID"));
                System.out.println("Name: " + rs.getString("Name"));
            }

            // Disconnect from the database
            handler.disconnect();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}