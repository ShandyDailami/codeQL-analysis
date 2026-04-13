import java.sql.*;

public class java_38913_JDBCQueryHandler_A07 {

    private static final String URL = "jdbc:yourdatabaseurl";
    private static final String USER = "yourusername";
    private static final String PASSWORD = "yourpassword";

    public static void main(String[] args) {
        try {
            // Step 1: Get a connection to the database
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);

            // Step 2: Prepare a statement
            Statement statement = connection.createStatement();

            // Step 3: Execute the query
            ResultSet resultSet = statement.executeQuery("SELECT * FROM your_table");

            // Step 4: Process the results
            while (resultSet.next()) {
                // Access the data using getter methods
                String column1 = resultSet.getString("column1");
                int column2 = resultSet.getInt("column2");
                // ... and so on
            }

            // Step 5: Close the connection
            resultSet.close();
            statement.close();
            connection.close();

        } catch (SQLException e) {
            // Handle the failure here
            e.printStackTrace();
        }
    }
}