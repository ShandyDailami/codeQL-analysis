import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class java_13089_JDBCQueryHandler_A01 {

    // Step 1: Secure Connection
    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/mydatabase";
    private static final String USERNAME = "username";
    private static final String PASSWORD = "password";

    private Connection connection;

    public java_13089_JDBCQueryHandler_A01() {
        try {
            // Step 2: Secure Driver loading
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Step 3: Secure Connection Creation
            this.connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    // Step 4: Secure Data Access
    public ResultSet executeQuery(String query) {
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultSet;
    }

    // Step 5: Secure Data Manipulation
    public int executeUpdate(String query) {
        Statement statement = null;
        int rowsUpdated = 0;
        try {
            statement = connection.createStatement();
            rowsUpdated = statement.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowsUpdated;
    }

    // Step 6: Secure Closing
    public void closeConnection() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}