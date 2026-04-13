import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class java_07828_JDBCQueryHandler_A03 {

    public static void main(String[] args) {

        // Step 1: Load the database driver
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("MySQL JDBC Driver not found!");
            e.printStackTrace();
        }

        // Step 2: Create a connection to the database
        Connection conn = null;
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "user", "password");
        } catch (SQLException e) {
            System.out.println("Connection failed!");
            e.printStackTrace();
            return;
        }

        // Step 3: Execute a query
        if (conn != null) {
            Statement stmt = null;
            try {
                stmt = conn.createStatement();
                String sql = "SELECT * FROM employees";
                ResultSet rs = stmt.executeQuery(sql);

                // Step 4: Process the results
                while (rs.next()) {
                    int id = rs.getInt("id");
                    String name = rs.getString("name");
                    System.out.println("id: " + id + ", name: " + name);
                }
            } catch (SQLException e) {
                System.out.println("Error processing the query!");
                e.printStackTrace();
            }
        }

        // Step 5: Close the connection
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                System.out.println("Error closing the connection!");
                e.printStackTrace();
            }
        }
    }
}