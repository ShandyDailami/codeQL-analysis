import java.sql.*;

public class java_25353_JDBCQueryHandler_A01 {
    private static final String URL = "jdbc:mysql://localhost:3306/mydb";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            // Step 1: Establish a connection
            connection = DriverManager.getConnection(URL, USER, PASSWORD);

            // Step 2: Prepare a statement
            String query = "SELECT * FROM my_table WHERE column1 = ?";
            preparedStatement = connection.prepareStatement(query);

            // Step 3: Set parameters and execute query
            preparedStatement.setString(1, "someValue"); // Replace "someValue" with actual value
            ResultSet resultSet = preparedStatement.executeQuery();

            // Step 4: Process the result
            while (resultSet.next()) {
                System.out.println("Column 1: " + resultSet.getString("column1"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Step 6: Close resources
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}