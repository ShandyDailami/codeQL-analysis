import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class java_25607_JDBCQueryHandler_A03 {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/testdb";
        String username = "root";
        String password = "password";

        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            // Step 1: Register JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Step 2: Open a connection
            connection = DriverManager.getConnection(url, username, password);

            // Step 3: Prepare a statement
            String sql = "INSERT INTO employees (id, name, salary) VALUES (?, ?, ?)";
            preparedStatement = connection.prepareStatement(sql);

            // Step 4: Set parameters and execute
            preparedStatement.setInt(1, 100);
            preparedStatement.setString(2, "John Doe");
            preparedStatement.setDouble(3, 50000.00);
            preparedStatement.executeUpdate();

            System.out.println("Insertion Successful");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Step 5: Close resources
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }

            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
        }
    }
}