import java.sql.*;

public class java_40263_JDBCQueryHandler_A07 {
    public String getPassword(String username) {
        String password = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // Load MySQL JDBC driver

            String url = "jdbc:mysql://localhost:3306/mydatabase"; // Database URL
            String usernameDB = "root"; // Database username
            String passwordDB = "password"; // Database password

            Connection connection = DriverManager.getConnection(url, usernameDB, passwordDB); // Connect to database

            String query = "SELECT password FROM users WHERE username = ?"; // SQL query

            PreparedStatement statement = connection.prepareStatement(query); // Prepare statement for execution
            statement.setString(1, username); // Set parameter in statement

            ResultSet result = statement.executeQuery(); // Execute the statement

            if (result.next()) { // Check if there is a result
                password = result.getString("password"); // Retrieve password
            }

            connection.close(); // Close connection
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }

        return password;
    }
}