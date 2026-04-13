import java.sql.*;

public class java_19005_JDBCQueryHandler_A07 {
    private Connection connection;
    private Statement statement;

    public java_19005_JDBCQueryHandler_A07(String dbURL, String username, String password) {
        try {
            // Step 1: Establish a connection
            this.connection = DriverManager.getConnection(dbURL, username, password);

            // Step 2: Create a statement
            this.statement = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void executeQuery(String query) {
        try {
            // Step 3: Execute the query
            ResultSet resultSet = statement.executeQuery(query);

            // Step 4: Process the result set
            while (resultSet.next()) {
                System.out.println(resultSet.getString("username") + " - " + resultSet.getString("password"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void closeConnection() {
        try {
            // Step 5: Close the statement and the connection
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}