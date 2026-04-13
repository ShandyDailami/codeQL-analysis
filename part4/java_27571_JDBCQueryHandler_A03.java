import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class java_27571_JDBCQueryHandler_A03 {
    public static void main(String[] args) {
        // Load MySQL driver
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("MySQL Java Connector is not found!");
        }

        // Connect to database
        try (Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/mydb", "username", "password")) {

            // Prepare statement
            try (Statement stmt = conn.createStatement()) {

                // Execute SQL query
                ResultSet rs = stmt.executeQuery("SELECT * FROM mytable");

                // Process ResultSet
                while (rs.next()) {
                    System.out.println(rs.getString("col1") + " - " + rs.getString("col2"));
                }
            }

        } catch (SQLException e) {
            System.out.println("Error in connection or SQL execution: " + e.getMessage());
        }
    }
}