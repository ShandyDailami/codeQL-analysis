import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class java_22577_JDBCQueryHandler_A08 {

    // Step 1: JDBC driver name and database URL
    private static final String DATABASE_DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/testdb";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "password";

    // Step 2: Create a Connection object
    private Connection connection = null;
    private PreparedStatement statement = null;

    // Step 3: Establish a Connection to the database
    public java_22577_JDBCQueryHandler_A08() {
        try {
            Class.forName(DATABASE_DRIVER);
            connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    // Step 4: Create a Query (e.g., to select all employees)
    public ResultSet executeQuery(String query) {
        try {
            statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();

            return resultSet;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // Step 5: Close Connection and Statement
    public void closeConnection() {
        try {
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

    // Step 6: Execute an SQL statement with a parameter.
    public int executeUpdate(String query) {
        try {
            statement = connection.prepareStatement(query);
            int rowsAffected = statement.executeUpdate();
            return rowsAffected;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }
}