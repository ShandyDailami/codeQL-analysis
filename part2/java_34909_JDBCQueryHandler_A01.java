import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class java_34909_JDBCQueryHandler_A01 {

    private Connection connection;

    public java_34909_JDBCQueryHandler_A01(String dbURL, String user, String password) throws SQLException {
        connection = DriverManager.getConnection(dbURL, user, password);
    }

    public List<String> executeQuery(String query) throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query);

        List<String> result = new ArrayList<>();
        while (resultSet.next()) {
            result.add(resultSet.getString("columnName"));
        }
        return result;
    }

    public void closeConnection() throws SQLException {
        connection.close();
    }
}