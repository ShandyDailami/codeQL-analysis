public class java_25277_SessionManager_A03 {

    private Connection connection;

    public java_25277_SessionManager_A03(String url, String user, String password) throws SQLException {
        DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
        connection = DriverManager.getConnection(url, user, password);
    }

    public void closeSession() throws SQLException {
        if (connection != null && !connection.isClosed()) {
            connection.close();
        }
    }

    public Object executeQuery(String query, Object[] params, String resultSetHandler) throws SQLException {
        PreparedStatement stmt = connection.prepareStatement(query);
        for (int i = 0; i < params.length; i++) {
            stmt.setObject(i, params[i]);
        }
        ResultSet rs = stmt.executeQuery();
        if (resultSetHandler != null) {
            return rs.getResultSetMetaData().getResultSetConversion().convertRowMetadataToObject(rs.getMetaData());
        } else {
            return rs.executeUpdate() == 0 ? null : rs;
        }
    }
}