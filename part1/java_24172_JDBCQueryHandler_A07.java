import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class java_24172_JDBCQueryHandler_A07 {
    private String url;
    private String username;
    private String password;

    public java_24172_JDBCQueryHandler_A07(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    public List<String> executeQuery(String query) {
        List<String> results = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection(url, username, password);
             Statement statement = connection.createStatement()) {

            ResultSet resultSet = statement.executeQuery(query);

            ResultSetMetaData metaData = resultSet.getMetaData();
            int columnCount = metaData.getColumnCount();

            while (resultSet.next()) {
                for (int i = 1; i <= columnCount; i++) {
                    String columnValue = resultSet.getString(i);
                    results.add(columnValue);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return results;
    }
}