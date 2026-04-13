import java.sql.*;

public class java_40413_JDBCQueryHandler_A03 {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String username = "username";
        String password = "password";

        try {
            // Step 1: Establish the connection
            Connection connection = DriverManager.getConnection(url, username, password);

            // Step 2: Prepare the statement
            Statement statement = connection.createStatement();

            // Step 3: Execute the query
            ResultSet resultSet = statement.executeQuery("SELECT * FROM mytable");

            // Step 4: Process the result
            while (resultSet.next()) {
                System.out.println("ID: " + resultSet.getInt("id"));
                System.out.println("Name: " + resultSet.getString("name"));
            }

            // Step 5: Close the connection
            connection.close();

        } catch (SQLException e) {
            System.out.println("Error occurred: " + e.getMessage());
        }
    }
}