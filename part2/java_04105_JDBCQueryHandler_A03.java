public class java_04105_JDBCQueryHandler_A03 {

    private static final String URL = "your_url";
    private static final String USER = "your_username";
    private static final String PASSWORD = "your_password";

    public List<Map<String, Object>> executeQuery(String query, Binding binding) throws SQLException {
        Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
        PreparedStatement preparedStatement = connection.prepareStatement(query);

        // Bind values to query parameters
        for (int i = 0; i < binding.size(); i++) {
            preparedStatement.setObject(i + 1, binding.get(i));
        }

        ResultSet resultSet = preparedStatement.executeQuery();

        List<Map<String, Object>> result = new ArrayList<>();
        ResultSetMetaData metaData = resultSet.getMetaData();
        int columnCount = metaData.getColumnCount();

        while (resultSet.next()) {
            Map<String, Object> row = new HashMap<>();
            for (int i = 1; i <= columnCount; i++) {
                row.put(metaData.getColumnName(i), resultSet.getObject(i));
            }
            result.add(row);
        }

        connection.close();
        return result;
    }
}