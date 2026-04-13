import java.sql.*;
import org.apache.commons.dbcp2.BasicDataSource;

public class java_28759_SessionManager_A07 {
    private BasicDataSource dataSource;

    public java_28759_SessionManager_A07() {
        dataSource = new BasicDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/mydatabase");
        dataSource.setUsername("myusername");
        dataSource.setPassword("mypassword");
        dataSource.setMinIdle(5);
        dataSource.setMaxIdle(10);
        dataSource.setMaxOpenPreparedStatements(100);
    }

    public Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }

    public Session createSession() throws SQLException {
        Connection connection = getConnection();
        return connection.newSession();
    }

    public void closeSession(Session session) throws SQLException {
        session.close();
    }

    public void saveSession(Session session, String sessionData) {
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.save(sessionData);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public String getSessionData(Session session, String sessionId) {
        return (String) session.get(sessionId);
    }
}