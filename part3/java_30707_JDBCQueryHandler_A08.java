import java.sql.*;

public class java_30707_JDBCQueryHandler_A08 {
    // Database credentials
    private static final String DB_USERNAME = "db_username";
    private static final String DB_PASSWORD = "db_password";
    private static final String DB_URL = "jdbc:mysql://localhost:3306/mydb";

    private Connection connection;

    public java_30707_JDBCQueryHandler_A08() {
        try {
            // Load the MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish a connection
            connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public ResultSet executeQuery(String query) {
        try {
            // Prepare the statement
            PreparedStatement statement = connection.prepareStatement(query);

            // Execute the statement and get the result
            return statement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public void executeUpdate(String query) {
        try {
            // Prepare the statement
            PreparedStatement statement = connection.prepareStatement(query);

            // Execute the statement
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void closeConnection() {
        try {
            // Close the connection
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        JDBCQueryHandler queryHandler = new JDBCQueryHandler();

        ResultSet resultSet = queryHandler.executeQuery("SELECT * FROM my_table");

        // Process the result set
        while (resultSet.next()) {
            String column1 = resultSet.getString("column1");
            // ...

            System.out.println("column1: " + column1);
        }

        queryHandler.closeConnection();
    }
}