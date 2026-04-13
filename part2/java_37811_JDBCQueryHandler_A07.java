import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class java_37811_JDBCQueryHandler_A07 {
    private Connection connection;

    public java_37811_JDBCQueryHandler_A07(String url, String username, String password) throws SQLException {
        this.connection = DriverManager.getConnection(url, username, password);
    }

    public List<String> query(String sql) throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);

        List<String> result = new ArrayList<>();
        while (resultSet.next()) {
            result.add(resultSet.getString("column_name"));
        }
        return result;
    }

    public void closeConnection() throws SQLException {
        connection.close();
    }
}