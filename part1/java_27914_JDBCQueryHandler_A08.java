import java.sql.*;

public class java_27914_JDBCQueryHandler_A08 {

    private static final String URL = "jdbc:yourDatabaseURL";
    private static final String USER = "yourUsername";
    private static final String PASSWORD = "yourPassword";

    public static void main(String[] args) {
        try {
            // Step 1: Establish a connection
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);

            // Step 2: Prepare a statement
            String SQL = "SELECT * FROM yourTable"; // replace with your query
            Statement statement = connection.createStatement();

            // Step 3: Execute the statement
            ResultSet resultSet = statement.executeQuery(SQL);

            // Step 4: Process the result
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                int age = resultSet.getInt("age");
                // add more code here if needed
            }

            // Step 5: Clean up
            resultSet.close();
            statement.close();
            connection.close();

        } catch (SQLException e) {
            System.out.println("Error executing SQL: " + e.getMessage());
        }
    }
}