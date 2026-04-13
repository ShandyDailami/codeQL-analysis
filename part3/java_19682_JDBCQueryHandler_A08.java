import java.sql.*;

public class java_19682_JDBCQueryHandler_A08 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String username = "root";
        String password = "password";

        try {
            // Step 1: Load the Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Step 2: Establish a Connection
            Connection connection = DriverManager.getConnection(url, username, password);

            // Step 3: Create a Statement
            Statement statement = connection.createStatement();

            // Step 4: Execute a Query
            String query = "SELECT * FROM my_table";
            ResultSet resultSet = statement.executeQuery(query);

            // Step 5: Process the ResultSet
            while (resultSet.next()) {
                System.out.println("ID: " + resultSet.getInt("id"));
                System.out.println("Name: " + resultSet.getString("name"));
                // etc...
            }

            // Step 6: Clean Up
            resultSet.close();
            statement.close();
            connection.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}