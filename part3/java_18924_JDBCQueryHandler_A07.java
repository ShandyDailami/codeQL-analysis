import java.sql.*;

public class java_18924_JDBCQueryHandler_A07 {
    private static final String URL = "jdbc:mysql://localhost:3306/testdb";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        try {
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);

            // Step 1: Prepare the SQL statement
            String query = "SELECT * FROM users WHERE name = ?";
            PreparedStatement statement = connection.prepareStatement(query);

            // Step 2: Set the parameter value
            statement.setString(1, "John");

            // Step 3: Execute the query
            ResultSet result = statement.executeQuery();

            // Step 4: Process the result
            while (result.next()) {
                String name = result.getString("name");
                int age = result.getInt("age");
                System.out.println("Name: " + name);
                System.out.println("Age: " + age);
            }

            // Close the resources
            result.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}