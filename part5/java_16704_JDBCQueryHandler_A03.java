import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class java_16704_JDBCQueryHandler_A03 {

    public static void main(String[] args) {
        // Load the MySQL driver
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("MySQL JDBC driver not found. Exiting...");
            e.printStackTrace();
            System.exit(1);
        }

        // Create a connection to the database
        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String username = "username";
        String password = "password";

        try (Connection conn = DriverManager.getConnection(url, username, password)) {
            System.out.println("Connected to the database!");

            // Create a statement
            try (Statement stmt = conn.createStatement()) {
                // Execute a query
                ResultSet rs = stmt.executeQuery("SELECT * FROM mytable");

                // Process the result set
                while (rs.next()) {
                    System.out.println(rs.getString("columnName"));
                }
            }
        } catch (SQLException e) {
            System.out.println("Error connecting to the database");
            e.printStackTrace();
        }
    }
}