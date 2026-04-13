import java.sql.*;

public class java_33475_JDBCQueryHandler_A08 {
    public static final String URL = "jdbc:mysql://localhost:3306/mydatabase";
    public static final String USER = "root";
    public static final String PASS = "password";

    public static void main(String[] args) {
        try {
            // Step 1: Establish a connection
            Connection connection = DriverManager.getConnection(URL, USER, PASS);

            // Step 2: Prepare the statement
            String query = "SELECT * FROM my_table WHERE my_column = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);

            // Step 3: Set the parameter value
            preparedStatement.setString(1, "some_value");

            // Step 4: Execute the statement
            ResultSet resultSet = preparedStatement.executeQuery();

            // Step 5: Process the result
            while (resultSet.next()) {
                String value = resultSet.getString("my_column");
                System.out.println("Value: " + value);
            }

            // Step 6: Close the connection
            resultSet.close();
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}