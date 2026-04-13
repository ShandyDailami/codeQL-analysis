import java.sql.*;

public class java_28257_JDBCQueryHandler_A08 {
    private static final String URL = "jdbc:mysql://localhost:3306/mydb";
    private static final String USER = "user";
    private static final String PASS = "password";

    public static void main(String[] args) {
        try {
            // Step 1: Initialize the connection
            Connection connection = DriverManager.getConnection(URL, USER, PASS);

            // Step 2: Prepare the statement
            String query = "SELECT * FROM Users WHERE role = 'Admin'";
            Statement statement = connection.createStatement();

            // Step 3: Execute the query
            ResultSet resultSet = statement.executeQuery(query);

            // Step 4: Process the result
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                String role = resultSet.getString("role");
                System.out.println("Name: " + name + ", Role: " + role);
            }

            // Step 5: Close the connection
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}