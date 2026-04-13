import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class java_40030_JDBCQueryHandler_A08 {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/test";
    private static final String USER = "user";
    private static final String PASS = "password";

    public static void main(String[] args) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            // Step 1: Load MySQL JDBC driver.
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Step 2: Open a connection to the database.
            connection = DriverManager.getConnection(DB_URL, USER, PASS);

            // Step 3: Create a statement.
            String sql = "SELECT * FROM Users WHERE ID = ?";
            preparedStatement = connection.prepareStatement(sql);

            // Step 4: Set parameter and execute the statement.
            preparedStatement.setInt(1, 123); // Replace 123 with ID of the user you want to fetch.
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                System.out.println(resultSet.getString("username"));
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            // Step 6: Close the resources.
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