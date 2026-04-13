import java.sql.*;

public class java_21490_JDBCQueryHandler_A01 {

    //Database credentials
    private static final String DB_URL = "jdbc:mysql://localhost:3306/testdb";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "password";

    //JDBC variables
    private Connection connection;
    private Statement statement;

    // Constructor to initialize the database connection
    public java_21490_JDBCQueryHandler_A01() {
        try {
            connection = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            statement = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Example method to retrieve data from a table
    public ResultSet executeQuery(String query) {
        try {
            return statement.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    // Example method to insert data into a table
    public int executeUpdate(String query) {
        try {
            return statement.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }
    }

    // Example method to close the database connection
    public void close() {
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

    public static void main(String[] args) {
        JDBCQueryHandler jdbcQueryHandler = new JDBCQueryHandler();
        ResultSet resultSet = jdbcQueryHandler.executeQuery("SELECT * FROM Users");

        // Use the result set...

        jdbcQueryHandler.close();
    }
}