import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class java_25244_JDBCQueryHandler_A07 {
    // Database credentials
    private static final String USER = "your_username";
    private static final String PASSWORD = "your_password";
    private static final String URL = "jdbc:mysql://your_server/your_database";

    // Main method
    public static void main(String[] args) {
        try {
            // Load the MySQL driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Connect to the database
            Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);

            // Create a statement
            Statement stmt = conn.createStatement();

            // Execute the query
            ResultSet rs = stmt.executeQuery("SELECT * FROM your_table");

            // Process the result set
            while (rs.next()) {
                System.out.println(rs.getString("your_column"));
            }

            // Close the connection
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}