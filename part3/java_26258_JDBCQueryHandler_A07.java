import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class java_26258_JDBCQueryHandler_A07 {
    private static final String URL = "jdbc:mysql://localhost:3306/mydb";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            // Step 1: Load MySQL Connector/J library.
            // Important: It should be done before using any database operations.
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Step 2: Establish a connection to the database.
            connection = DriverManager.getConnection(URL, USER, PASSWORD);

            // Step 3: Prepare SQL statement.
            String query = "SELECT * FROM myTable WHERE myCondition = ?";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, "someValue"); // Replace with actual value

            // Step 4: Execute the SQL statement.
            resultSet = preparedStatement.executeQuery();

            // Step 5: Process the result set.
            while (resultSet.next()) {
                String column1 = resultSet.getString("column1");
                // More columns...
                System.out.println("Column 1: " + column1);
            }

            // Step 6: Clean up the resources.
            preparedStatement.close();
            resultSet.close();
            connection.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}