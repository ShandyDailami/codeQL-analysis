public class java_02181_JDBCQueryHandler_A03 {

    private final DataSource dataSource;

    public java_02181_JDBCQueryHandler_A03(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public List<Map<String, Object>> executeQuery(String query, Object[] params) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            for (int i = 0; i < params.length; i++) {
                statement.setObject(i, params[i]);
            }

            ResultSet resultSet = statement.executeQuery();

            List<Map<String, Object>> result = new ArrayList<>();
            ResultSetMetaData metaData = resultSet.getMetaData();
            int columnCount = metaData.getColumnCount();

            while (resultSet.next()) {
                Map<String, Object> row = new HashMap<>();
                for (int i = 1; i <= columnCount; i++) {
                    String columnLabel = metaData.getColumnLabel(i);
                    Object value = resultSet.getObject(columnLabel);
                    row.put(columnLabel, value);
                }
                result.add(row);
            }

            return result;

        } catch (SQLException e) {
            throw new UncategorizedSQLException("Error executing query", e);
        }
    }
}