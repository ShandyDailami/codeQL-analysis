import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class java_36444_JDBCQueryHandler_A01 {

    // Step 1: Establish a connection to the database
    private Connection connection;

    public java_36444_JDBCQueryHandler_A01(String dbURL, String user, String password) throws SQLException {
        connection = DriverManager.getConnection(dbURL, user, password);
    }

    // Step 2: Execute a SQL Query
    public ResultSet executeQuery(String query) throws SQLException {
        Statement statement = connection.createStatement();
        return statement.executeQuery(query);
    }

    // Step 3: Handle the ResultSet
    public void handleResultSet(ResultSet resultSet) throws SQLException {
        ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
        int columnCount = resultSetMetaData.getColumnCount();

        while (resultSet.next()) {
            for (int i = 1; i <= columnCount; i++) {
                String columnLabel = resultSetMetaData.getColumnLabel(i);
                Object columnValue = resultSet.getObject(i);
                System.out.println(columnLabel + ": " + columnValue);
            }
        }
    }

    // Step 4: Close the connection
    public void closeConnection() throws SQLException {
        connection.close();
    }

    public static void main(String[] args) throws SQLException {
        String dbURL = "jdbc:mysql://localhost:3306/testdb";
        String user = "root";
        String password = "password";

        JDBCQueryHandler queryHandler = new JDBCQueryHandler(dbURL, user, password);

        String query = "SELECT * FROM users";
        ResultSet resultSet = queryHandler.executeQuery(query);

        queryHandler.handleResultSet(resultSet);

        queryHandler.closeConnection();
    }
}