import java.sql.*;

public class java_12114_JDBCQueryHandler_A08 {

    private Connection connection;

    public java_12114_JDBCQueryHandler_A08(String url, String user, String password) {
        try {
            this.connection = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            throw new IllegalStateException("Cannot connect to database", e);
        }
    }

    public List<Map<String, Object>> query(String sql, Object... params) {
        List<Map<String, Object>> results = new ArrayList<>();

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            for (int i = 0; i < params.length; i++) {
                statement.setObject(i, params[i]);
            }

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Map<String, Object> row = new HashMap<>();
                for (int i = 1; i <= resultSet.getMetaData().getColumnCount(); i++) {
                    row.put(resultSet.getMetaData().getColumnLabel(i), resultSet.getObject(i));
                }
                results.add(row);
            }
        } catch (SQLException e) {
            System.out.println("An error occurred while executing the query.");
            e.printStackTrace();
        }

        return results;
    }
}