public class java_32809_SessionManager_A07 {
    private Session session;

    public java_32809_SessionManager_A07(String url, String user, String password) throws SQLException {
        this.session = DriverManager.getConnection(url, user, password);
    }

    public void startTransaction() throws SQLException {
        this.session.setAutoCommit(false);
    }

    public void save(String query, Object value) throws SQLException {
        PreparedStatement statement = session.prepareStatement(query);
        statement.setObject(1, value);
        statement.executeUpdate();
    }

    public void commitTransaction() throws SQLException {
        this.session.commit();
        this.session.setAutoCommit(true);
    }

    public void rollbackTransaction() throws SQLException {
        this.session.rollback();
    }

    public void closeSession() throws SQLException {
        this.session.close();
    }
}