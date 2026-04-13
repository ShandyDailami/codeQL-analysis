import java.sql.*;

public class java_11649_JDBCQueryHandler_A01 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String username = "root";
        String password = "password";

        try {
            // Step 1: Load the MySQL driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Step 2: Connect to the database
            Connection connection = DriverManager.getConnection(url, username, password);

            // Step 3: Prepare a statement
            Statement statement = connection.createStatement();

            // Step 4: Execute the query
            String query = "SELECT * FROM users WHERE role='admin'";
            ResultSet result = statement.executeQuery(query);

            // Step 5: Process the results
            while (result.next()) {
                String username = result.getString("username");
                String password = result.getString("password");
                String email = result.getString("email");

                System.out.println("Username: " + username);
                System.out.println("Password: " + password);
                System.out.println("Email: " + email);
            }

            // Step 6: Close the connection
            result.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            System.out.println("Error executing query: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("MySQL JDBC driver not found. DB connection is not established.");
        }
    }
}