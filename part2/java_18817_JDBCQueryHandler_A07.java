import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class java_18817_JDBCQueryHandler_A07 {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/mydb";
        String username = "username";
        String password = "password";

        // Step 1: Load the MySQL driver
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("MySQL Java driver not found.");
            e.printStackTrace();
            return;
        }

        // Step 2: Establish a connection
        try (Connection conn = DriverManager.getConnection(url, username, password)) {
            System.out.println("Connected to the database.");

            // Step 3: Execute a query
            try (Statement stmt = conn.createStatement()) {
                String sql = "SELECT * FROM Users WHERE id = " + Integer.toString(1);
                ResultSet rs = stmt.executeQuery(sql);

                while (rs.next()) {
                    System.out.println("User id: " + rs.getString("id"));
                }
            } catch (SQLException e) {
                System.out.println("Error executing query: " + e.getMessage());
                e.printStackTrace();
            }
        } catch (SQLException e) {
            System.out.println("Error connecting to the database: " + e.getMessage());
            e.printStackTrace();
        }
    }
}