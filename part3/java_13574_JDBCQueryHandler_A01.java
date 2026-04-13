import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class java_13574_JDBCQueryHandler_A01 {

    public static void main(String[] args) {

        // Step 1: Load the database driver
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("MySQL JDBC Driver is not found. Exiting...");
            e.printStackTrace();
            System.exit(1);
        }

        // Step 2: Establish the connection to the database
        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String username = "root";
        String password = "password";

        Connection conn = null;
        Statement stmt = null;

        try {
            conn = DriverManager.getConnection(url, username, password);
            System.out.println("Connected to the MySQL database");

            // Step 3: Execute the query
            stmt = conn.createStatement();
            String query = "SELECT * FROM mytable";
            ResultSet rs = stmt.executeQuery(query);

            // Step 4: Process the results
            while (rs.next()) {
                String name = rs.getString("name");
                int age = rs.getInt("age");
                String email = rs.getString("email");

                System.out.println("Name: " + name);
                System.out.println("Age: " + age);
                System.out.println("Email: " + email);
            }

            // Step 5: Close the connection
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            System.out.println("Error in connecting to the MySQL database");
            e.printStackTrace();
        }
    }
}