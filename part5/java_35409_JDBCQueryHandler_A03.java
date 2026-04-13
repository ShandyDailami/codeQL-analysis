import java.sql.*;
import java.util.*;

public class java_35409_JDBCQueryHandler_A03 {

    private Properties props;
    private String url;
    private String username;
    private String password;

    public java_35409_JDBCQueryHandler_A03(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
        this.props = new Properties();
        this.props.setProperty("user", this.username);
        this.props.setProperty("password", this.password);
    }

    public List<Map<String, Object>> executeQuery(String query) throws SQLException {
        Connection connection = DriverManager.getConnection(url, props);
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query);
        List<Map<String, Object>> result = new ArrayList<>();
        ResultSetMetaData metaData = resultSet.getMetaData();
        int columnCount = metaData.getColumnCount();
        while (resultSet.next()) {
            Map<String, Object> row = new HashMap<>();
            for (int i = 1; i <= columnCount; i++) {
                String columnLabel = metaData.getColumnLabel(i);
                Object value = resultSet.getObject(i);
                row.put(columnLabel, value);
            }
            result.add(row);
        }
        connection.close();
        return result;
    }
}