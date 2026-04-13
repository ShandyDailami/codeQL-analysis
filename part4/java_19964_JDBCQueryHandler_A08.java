import java.sql.*;

public class java_19964_JDBCQueryHandler_A08 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/mydb";
        String username = "root";
        String password = "password";

        try {
            // Step 1: Establish a connection to the database
            Connection connection = DriverManager.getConnection(url, username, password);

            // Step 2: Prepare a statement
            String query = "SELECT * FROM my_table";
            Statement statement = connection.createStatement();

            // Step 3: Execute the statement
            ResultSet resultSet = statement.executeQuery(query);

            // Step 4: Process the result
            while (resultSet.next()) {
                System.out.println("ID: " + resultSet.getInt("id"));
                System.out.println("Name: " + resultSet.getString("name"));
            }

            // Close the connection
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            System.out.println("Error in database connection: " + e.getMessage());
        }
    }
}