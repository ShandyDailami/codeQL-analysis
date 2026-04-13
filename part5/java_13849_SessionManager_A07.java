import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class java_13849_SessionManager_A07 {

    private static final String DB_URL = "jdbc:mysql://localhost:3306/testdb";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        try {
            // Step 1: Load the MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Step 2: Establish a connection to the database
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);

            // Step 3: Execute a SQL statement
            String query = "SELECT password FROM Users WHERE username = ?";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            if (rs.next()) {
                String dbPassword = rs.getString("password");

                // Step 4: Compare the user input password with the stored password
                if (dbPassword.equals(PASSWORD)) {
                    System.out.println("Access granted");
                } else {
                    System.out.println("Access denied");
                }
            }

            // Step 5: Close the ResultSet and Statement
            rs.close();
            stmt.close();

            // Step 6: Close the Connection
            conn.close();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}