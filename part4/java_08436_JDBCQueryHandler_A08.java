import java.sql.*;

public class java_08436_JDBCQueryHandler_A08 {
    private static final String URL = "jdbc:mysql://localhost:3306/your_database";
    private static final String USER = "your_username";
    private static final String PASSWORD = "your_password";

    public static void main(String[] args) {
        try {
            // Step 1: Establish the connection
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);

            // Step 2: Create a statement
            Statement statement = connection.createStatement();

            // Step 3: Execute a SQL query
            ResultSet resultSet = statement.executeQuery("SELECT * FROM your_table");

            // Step 4: Process the result
            while (resultSet.next()) {
                // Assume that your table has a name column
                String name = resultSet.getString("name");
                // Do something with the name
                System.out.println("Name: " + name);
            }

            // Step 5: Close the connection
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            System.out.println("Error while connecting to the database or executing the query: " + e.getMessage());
        }
    }
}