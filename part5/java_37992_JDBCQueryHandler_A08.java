import java.sql.*;

public class java_37992_JDBCQueryHandler_A08 {
    private static final String URL = "jdbc:mysql://localhost:3306/testdb";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        try {
            // Step 1: Establish connection
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);

            // Step 2: Prepare SQL query
            String sql = "SELECT * FROM users WHERE name = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, "testUser"); // Here you can use a user-provided value

            // Step 3: Execute SQL query
            ResultSet result = statement.executeQuery();

            // Step 4: Process result
            while (result.next()) {
                String name = result.getString("name");
                int age = result.getInt("age");
                System.out.println("Name: " + name + ", Age: " + age);
            }

            // Step 5: Clean up
            result.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}