import java.sql.*;

public class java_04535_JDBCQueryHandler_A01 {
    private Connection connection;
    private Statement statement;

    public java_04535_JDBCQueryHandler_A01(String dbUrl, String userName, String password) {
        try {
            // Step 1: Establish a connection
            this.connection = DriverManager.getConnection(dbUrl, userName, password);

            // Step 2: Create a statement
            this.statement = this.connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ResultSet executeQuery(String query) {
        ResultSet resultSet = null;
        try {
            // Step 3: Execute the query
            resultSet = this.statement.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultSet;
    }

    public int executeUpdate(String query) {
        int affectedRows = 0;
        try {
            // Step 4: Execute the update
            affectedRows = this.statement.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return affectedRows;
    }

    public void closeConnection() {
        try {
            // Step 5: Close the connection
            this.connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}