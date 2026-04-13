import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class java_05461_JDBCQueryHandler_A08 {

    public static void main(String[] args) {
        // Setup driver manager
        String url = "jdbc:mysql://localhost:3306/dbname";
        String username = "username";
        String password = "password";

        try {
            // Load the MySQL driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish the connection
            Connection conn = DriverManager.getConnection(url, username, password);

            // Create a statement
            Statement stmt = conn.createStatement();

            // Execute a query
            String sql = "SELECT * FROM table";
            ResultSet rs = stmt.executeQuery(sql);

            // Handle the result set
            while (rs.next()) {
                System.out.println(rs.getString("column"));
            }

            // Close the connections
            rs.close();
            stmt.close();
            conn.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}