import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class java_33395_JDBCQueryHandler_A03 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String username = "root";
        String password = "root";

        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            // 1. Load MySQL JDBC driver
            Class.forName("com.mysql.jdbc.Driver");

            // 2. Establish a connection
            connection = DriverManager.getConnection(url, username, password);

            // 3. Create a PreparedStatement
            String query = "SELECT * FROM employees WHERE name = ?";
            preparedStatement = connection.prepareStatement(query);

            // 4. Set parameters for query
            preparedStatement.setString(1, "John Doe");

            // 5. Execute query
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                System.out.println(resultSet.getString("name"));
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            // 6. Clean up
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