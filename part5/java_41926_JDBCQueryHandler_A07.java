import java.sql.*;

public class java_41926_JDBCQueryHandler_A07 {
    private static final String URL = "jdbc:mysql://localhost:3306/testdb";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        try {
            // Step 1: Establish a connection
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);

            // Step 2: Create a statement
            Statement statement = connection.createStatement();

            // Step 3: Execute a SQL query
            ResultSet resultSet = statement.executeQuery("SELECT * FROM AuthFailure WHERE id = " + someId);

            while (resultSet.next()) {
                // Step 4: Process the result
                String username = resultSet.getString("username");
                // ... process other fields as well

                // Step 5: Close the connection
                resultSet.close();
                statement.close();
                connection.close();
            }

            // Step 6: End the program
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}