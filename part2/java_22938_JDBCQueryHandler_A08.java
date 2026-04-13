import java.sql.*;
import java.util.*;

public class java_22938_JDBCQueryHandler_A08 {

    private String url;
    private String username;
    private String password;

    public java_22938_JDBCQueryHandler_A08(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    public List<Map<String, Object>> executeQuery(String query) throws SQLException {
        List<Map<String, Object>> result = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            try (Statement statement = connection.createStatement()) {
                try (ResultSet resultSet = statement.executeQuery(query)) {
                    ResultSetMetaData metaData = resultSet.getMetaData();
                    int columnCount = metaData.getColumnCount();

                    while (resultSet.next()) {
                        Map<String, Object> row = new HashMap<>();
                        for (int i = 1; i <= columnCount; i++) {
                            row.put(metaData.getColumnLabel(i), resultSet.getObject(i));
                        }
                        result.add(row);
                    }
                }
            }
        }

        return result;
    }
}