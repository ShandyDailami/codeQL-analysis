import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class java_31010_JDBCQueryHandler_A01 {

    private static final String url = "jdbc:mysql://localhost:3306/test";
    private static final String username = "root";
    private static final String password = "password";

    public static void main(String[] args) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            // Step 1: Load the MySQL driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Step 2: Open a connection
            connection = DriverManager.getConnection(url, username, password);

            // Step 3: Prepare a statement
            String sql = "SELECT * FROM users WHERE role = ?";
            preparedStatement = connection.prepareStatement(sql);

            // Step 4: Set the parameter
            preparedStatement.setString(1, "admin");

            // Step 5: Execute the query
            resultSet = preparedStatement.executeQuery();

            // Step 6: Process the result
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                String role = resultSet.getString("role");
                System.out.println("Name: " + name + ", Role: " + role);
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            // Step 7: Close the resources
            try {
                if (resultSet != null) resultSet.close();
                if (preparedStatement != null) preparedStatement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}