import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class java_37297_JDBCQueryHandler_A08 {
    public static void main(String[] args) {
        // Step 1: Load the driver
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // Assuming you are using MySQL JDBC driver
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        // Step 2: Connect to the database
        String url = "jdbc:mysql://localhost:3306/test";
        String username = "root";
        String password = "password";
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            connection = DriverManager.getConnection(url, username, password);
            statement = connection.createStatement();
            String sql = "SELECT * FROM A08_IntegrityFailure";
            resultSet = statement.executeQuery(sql);

            // Step 3: Process the results
            while (resultSet.next()) {
                System.out.println(resultSet.getString("columnName"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Step 4: Close the resources
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}