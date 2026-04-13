import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class java_35871_JDBCQueryHandler_A01 {

    private Connection connection;
    private Statement statement;

    public java_35871_JDBCQueryHandler_A01(String url, String user, String password) {
        try {
            // Step 1: Register JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Step 2: Establish a connection
            this.connection = DriverManager.getConnection(url, user, password);

            // Step 3: Create a statement
            this.statement = connection.createStatement();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public ResultSet executeQuery(String query) {
        try {
            // Step 4: Execute the query
            ResultSet resultSet = statement.executeQuery(query);

            // Step 5: Return the result set
            return resultSet;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public int executeUpdate(String query) {
        try {
            // Step 4: Execute the query
            int result = statement.executeUpdate(query);

            // Step 5: Return the result
            return result;
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }
    }

    public void close() {
        try {
            // Step 6: Close the statement and connection
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}