import java.sql.*;

public class java_28497_JDBCQueryHandler_A08 {

    private Connection connection;
    private Statement statement;
    private ResultSet resultSet;

    public void connectToDatabase(String dbURL, String userName, String password) {
        try {
            connection = DriverManager.getConnection(dbURL, userName, password);
            statement = connection.createStatement();
        } catch (SQLException e) {
            System.out.println("Error while connecting to the database.");
            e.printStackTrace();
        }
    }

    public void executeQuery(String query) {
        try {
            resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                System.out.println("Query result: " + resultSet.getString("column_name"));
            }
        } catch (SQLException e) {
            System.out.println("Error while executing the query.");
            e.printStackTrace();
        }
    }

    public void closeConnection() {
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
            System.out.println("Error while closing the connection.");
            e.printStackTrace();
        }
    }
}