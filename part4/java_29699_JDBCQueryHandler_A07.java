import java.sql.*;

public class java_29699_JDBCQueryHandler_A07 {
    public static void main(String[] args) {
        // Set up connection parameters
        String url = "jdbc:inmemory:authfailure";
        String username = "user";
        String password = "password";

        try {
            // Load drivers for SQLite in-memory database
            Class.forName("org.sqlite.JDBC");

            // Create a connection
            Connection conn = DriverManager.getConnection(url, username, password);

            // Create a statement
            Statement stmt = conn.createStatement();

            // Execute a query
            ResultSet rs = stmt.executeQuery("SELECT * FROM legacy_table");

            // Process the result set
            while (rs.next()) {
                System.out.println(rs.getString("column_name"));
            }

            // Close the connection
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            System.out.println("SQL Exception: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("Class Not Found Exception: " + e.getMessage());
        }
    }
}