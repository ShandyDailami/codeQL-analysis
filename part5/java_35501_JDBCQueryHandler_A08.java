import java.sql.*;

public class java_35501_JDBCQueryHandler_A08 {
    private static final String URL = "jdbc:mysql://localhost:3306/db_name";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        try {
            // Step 1: Establish a Connection
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);

            // Step 2: Prepare a Statement
            String query = "SELECT * FROM table_name WHERE condition";
            Statement statement = connection.createStatement();

            // Step 3: Execute the Statement
            ResultSet resultSet = statement.executeQuery(query);

            // Step 4: Process the ResultSet
            while (resultSet.next()) {
                String column1 = resultSet.getString("column1");
                int column2 = resultSet.getInt("column2");
                // Do something with the result
            }

            // Step 5: Close the Connection
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}