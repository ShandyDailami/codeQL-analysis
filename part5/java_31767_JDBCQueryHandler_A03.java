import java.sql.*;

public class java_31767_JDBCQueryHandler_A03 {
    private static final String url = "jdbc:mysql://localhost:3306/mydatabase";
    private static final String username = "root";
    private static final String password = "password";

    public static void main(String[] args) {
        try {
            // Step 1: Establish a connection
            Connection connection = DriverManager.getConnection(url, username, password);

            // Step 2: Prepare a statement
            String selectQuery = "SELECT name, age FROM people WHERE age = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(selectQuery);

            // Step 3: Set parameter and execute statement
            preparedStatement.setInt(1, 30); // age = 30
            ResultSet resultSet = preparedStatement.executeQuery();

            // Step 4: Process the result
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                int age = resultSet.getInt("age");
                System.out.println("Name: " + name + ", Age: " + age);
           
            }

            // Step 5: Close the connection
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}