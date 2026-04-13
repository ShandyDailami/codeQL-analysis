import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class java_30086_JDBCQueryHandler_A07 {
    private Connection connection;

    public java_30086_JDBCQueryHandler_A07(String url, String username, String password) {
        try {
            this.connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<String> executeQuery(String query) {
        List<String> result = new ArrayList<>();
        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                result.add(resultSet.getString("column_name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public void closeConnection() {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}