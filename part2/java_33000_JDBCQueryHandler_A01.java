import java.sql.*;

public class java_33000_JDBCQueryHandler_A01 {

    private static final String URL = "jdbc:mysql://localhost:3306/mydatabase";
    private static final String USER = "username";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        try {
            // Step 1: Establish a connection
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);

            // Step 2: Execute a query
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM mytable");

            // Step 3: Process the results
            while (resultSet.next()) {
                // Accessing the columns
                String column1 = resultSet.getString("column1");
                String column2 = resultSet.getString("column2");
                // ...
            }

            // Step 4: Cleanup
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}