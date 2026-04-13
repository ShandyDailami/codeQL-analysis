import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class java_25513_JDBCQueryHandler_A07 {
    public static void main(String[] args) {
        try {
            // Step 1: Load the database driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Step 2: Establish a connection
            Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost/testdb?useSSL=false", "username", "password");

            // Step 3: Create a Statement
            Statement stmt = conn.createStatement();

            // Step 4: Execute a SQL Query
            ResultSet rs = stmt.executeQuery("SELECT * FROM USERS WHERE AGE > 20");

            // Step 5: Process the ResultSet
            while (rs.next()) {
                String username = rs.getString("username");
                int age = rs.getInt("age");
                System.out.println("Username: " + username);
                System.out.println("Age: " + age);
            }

            // Step 6: Close the ResultSet, Statement and Connection
            rs.close();
            stmt.close();
            conn.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}