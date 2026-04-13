import java.sql.*;

public class java_14801_JDBCQueryHandler_A01 {
    private static final String url = "jdbc:mysql://localhost:3306/mydatabase";
    private static final String username = "root";
    private static final String password = "password";

    public static void main(String[] args) {
        try {
            // Step 1: Setup the Connection
            Connection connection = DriverManager.getConnection(url, username, password);

            // Step 2: Prepare the Statement
            Statement statement = connection.createStatement();

            // Step 3: Execute the Query
            ResultSet resultSet = statement.executeQuery("SELECT * FROM Users");

            // Step 4: Process the ResultSet
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                int age = resultSet.getInt("age");

                System.out.println("Name: " + name);
                System.out.println("Age: " + age);
            }

            // Step 5: Close the Connection
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}