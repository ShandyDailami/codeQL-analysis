import java.sql.*;

public class java_20275_JDBCQueryHandler_A01 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/test";
        String username = "root";
        String password = "password";

        try {
            // Establish a connection to the database
            Connection connection = DriverManager.getConnection(url, username, password);

            // Prepare a statement for database operations
            Statement statement = connection.createStatement();

            // Execute a query to get data from a table
            ResultSet resultSet = statement.executeQuery("SELECT * FROM Users");

            // Process the result set
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                System.out.println("Name: " + name);
                System.out.println("Email: " + email);
            }

            // Close the connection
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}