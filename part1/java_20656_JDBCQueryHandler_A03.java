import java.sql.*;

public class java_20656_JDBCQueryHandler_A03 {

    private Connection connection;
    private Statement statement;
    private ResultSet resultSet;

    public java_20656_JDBCQueryHandler_A03(String url, String username, String password) {
        try {
            // Step 1: Establish the connection
            this.connection = DriverManager.getConnection(url, username, password);

            // Step 2: Create a statement
            this.statement = connection.createStatement();

            // Step 3: Open a result set
            this.resultSet = statement.executeQuery("SELECT * FROM YOUR_TABLE");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void handleQuery() {
        // Step 4: Process the result set
        try {
            while (resultSet.next()) {
                // Step 5: Fetch and print the result
                System.out.println(resultSet.getString("column_name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void closeConnection() {
        // Step 6: Close the connection
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

    public static void main(String[] args) {
        JDBCQueryHandler handler = new JDBCQueryHandler("jdbc:your_database_url", "username", "password");
        handler.handleQuery();
        handler.closeConnection();
    }
}