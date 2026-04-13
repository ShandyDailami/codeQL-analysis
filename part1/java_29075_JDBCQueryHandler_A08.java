import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class java_29075_JDBCQueryHandler_A08 {
    private static Connection connection;
    private static PreparedStatement statement;

    // Method to establish a connection to the database
    public static void establishConnection(String dbUrl, String username, String password) throws SQLException {
        connection = DriverManager.getConnection(dbUrl, username, password);
    }

    // Method to close the connection to the database
    public static void closeConnection() throws SQLException {
        if (connection != null) {
            connection.close();
        }
    }

    // Method to execute a prepared statement
    public static ResultSet executePreparedStatement(String query) throws SQLException {
        statement = connection.prepareStatement(query);
        return statement.executeQuery();
    }

    // Method to execute a non-prepared statement
    public static void executeNonPreparedStatement(String query) throws SQLException {
        statement = connection.createStatement();
        statement.execute(query);
    }

    // Method to retrieve data from the ResultSet
    public static List<String> retrieveData(String query) throws SQLException {
        ResultSet resultSet = executePreparedStatement(query);
        List<String> data = new ArrayList<>();
        ResultSetMetaData metaData = resultSet.getMetaData();
        int columnCount = metaData.getColumnCount();

        while (resultSet.next()) {
            for (int i = 1; i <= columnCount; i++) {
                String columnValue = resultSet.getString(i);
                data.add(columnValue);
            }
        }
        return data;
    }
}