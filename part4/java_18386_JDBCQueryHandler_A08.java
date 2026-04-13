import java.sql.*;

public class java_18386_JDBCQueryHandler_A08 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/test";
        String username = "root";
        String password = "password";

        try {
            // Step 1: Establish a Connection
            Connection connection = DriverManager.getConnection(url, username, password);

            // Step 2: Prepare a Statement
            Statement statement = connection.createStatement();

            // Step 3: Execute a Query
            String query = "SELECT * FROM employees LIMIT 50";
            ResultSet resultSet = statement.executeQuery(query);

            // Step 4: Process the Result
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                int age = resultSet.getInt("age");
                System.out.println("Name: " + name + ", Age: " + age);
            }

            // Step 5: Close the Connection
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}