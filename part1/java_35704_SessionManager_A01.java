public class java_35704_SessionManager_A01 {
    private Session session;
    private Connection connection;

    public java_35704_SessionManager_A01(String url, String username, String password) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            this.connection = DriverManager.getConnection(url, username, password);
            this.session = connection.createSession(true, Session.AUTO_COMMIT);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void closeSession() {
        session.commit();
        session.close();
        connection.close();
    }

    public Session getSession() {
        return this.session;
    }

    public void performOperation(String sql) {
        Statement statement = session.createStatement(Session.TYPE_STMT);
        try {
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                // Perform operations related to security-sensitive operations
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        closeSession();
    }
}