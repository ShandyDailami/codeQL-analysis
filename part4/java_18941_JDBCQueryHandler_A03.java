import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class java_18941_JDBCQueryHandler_A03 {
    private Connection connection;

    public java_18941_JDBCQueryHandler_A03(String dbUrl, String userName, String password) throws SQLException {
        this.connection = DriverManager.getConnection(dbUrl, userName, password);
    }

    public List<String> query(String query) throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query);

        List<String> results = new ArrayList<>();
        while (resultSet.next()) {
            results.add(resultSet.getString("columnName"));
        }

        resultSet.close();
        statement.close();

        return results;
    }

    public void close() throws SQLException {
        if (connection != null) {
            connection.close();
        }
    }
}