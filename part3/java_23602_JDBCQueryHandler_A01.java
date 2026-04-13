import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class java_23602_JDBCQueryHandler_A01 {
    public static void main(String[] args) {
        // Database credentials
        String url = "jdbc:mysql://localhost:3306/testdb";
        String username = "username";
        String password = "password";

        // Establish a connection to the database
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url, username, password);

            // Example of a query
            String sql = "SELECT * FROM Users";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                String name = resultSet.getString("name");
                int age = resultSet.getInt("age");
                System.out.println("Name: " + name + ", Age: " + age);
            }

            // Close the connection
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Close the connection even if an exception was thrown
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