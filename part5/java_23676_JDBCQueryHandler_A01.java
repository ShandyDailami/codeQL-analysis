import java.sql.*;

public class java_23676_JDBCQueryHandler_A01 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/test";
        String username = "root";
        String password = "password";

        try {
            // Step 1: Establish a Connection to the Database
            Connection connection = DriverManager.getConnection(url, username, password);
            System.out.println("Connection established to " + url);

            // Step 2: Execute a Query
            String query = "SELECT * FROM Users";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            // Step 3: Process the Result Set
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                int age = resultSet.getInt("age");
                System.out.println("Name: " + name + ", Age: " + age);
            }

            // Step 4: Close the Connection
            resultSet.close();
            statement.close();
            connection.close();
            System.out.println("Connection closed");

        } catch (SQLException e) {
            System.out.println("Error in connection or query execution: " + e.getMessage());
        }
    }
}