import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class java_15388_JDBCQueryHandler_A01 {
    // Connection URL, User and Password
    private static final String URL = "jdbc:mysql://localhost:3306/test";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            // 1. Connect to the database
            connection = DriverManager.getConnection(URL, USER, PASSWORD);

            // 2. Create a new statement
            String query = "SELECT * FROM Users WHERE id = ?";
            preparedStatement = connection.prepareStatement(query);

            // 3. Set the parameter value
            preparedStatement.setInt(1, 1);

            // 4. Execute the statement
            resultSet = preparedStatement.executeQuery();

            // 5. Process the result
            while (resultSet.next()) {
                System.out.println("User id: " + resultSet.getInt("id"));
                System.out.println("User name: " + resultSet.getString("name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // 6. Close the resources
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
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