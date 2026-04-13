import java.sql.*;

public class java_13340_JDBCQueryHandler_A08 {
    public static void main(String[] args) {
        // String for database connection
        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String username = "root";
        String password = "password";

        try {
            // Load the Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Create the connection
            Connection connection = DriverManager.getConnection(url, username, password);

            // Prepare the statement
            String selectQuery = "SELECT * FROM my_table";
            Statement statement = connection.createStatement();

            // Execute the query
            ResultSet resultSet = statement.executeQuery(selectQuery);

            // Process the result
            while (resultSet.next()) {
                System.out.println("ID: " + resultSet.getInt("id"));
                System.out.println("Name: " + resultSet.getString("name"));
            }

            // Close the connection
            connection.close();

        } catch (SQLException e) {
            System.out.println("An error occurred: " + e.getMessage());
       
        } catch (ClassNotFoundException e) {
            System.out.println("Class not found: " + e.getMessage());
        }
    }
}