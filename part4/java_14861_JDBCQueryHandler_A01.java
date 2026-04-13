import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class java_14861_JDBCQueryHandler_A01 {

    // Step 1: Define the connection pool details
    private static final String DB_URL = "jdbc:mysql://localhost:3306/mydb";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    // Step 2: Use a connection pool
    private Connection connection;

    public java_14861_JDBCQueryHandler_A01() {
        try {
            // Step 3: Load the MySQL driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Step 4: Establish a connection
            this.connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    // Step 5: Define a method to execute a query
    public ResultSet executeQuery(String query) {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultSet;
    }

    // Step 6: Close the connection
    public void closeConnection() {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}