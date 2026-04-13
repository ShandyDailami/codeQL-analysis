import java.sql.*;

public class java_39067_SessionManager_A08 {
    private DataSource dataSource;

    public java_39067_SessionManager_A08(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public Session openSession() {
        try {
            Connection connection = dataSource.getConnection();
            return new Session(connection);
        } catch (SQLException e) {
            throw new SessionException("Failed to open session", e);
        }
    }

    public void closeSession(Session session) {
        try {
            session.getConnection().close();
        } catch (SQLException e) {
            throw new SessionException("Failed to close session", e);
        }
    }

    public class Session implements AutoCloseable {
        private Connection connection;

        public java_39067_SessionManager_A08(Connection connection) {
            this.connection = connection;
        }

        public Connection getConnection() {
            return connection;
        }

        @Override
        public void close() {
            closeSession(this);
        }
    }

    public static class SessionException extends RuntimeException {
        public java_39067_SessionManager_A08(String message, Throwable cause) {
            super(message, cause);
        }
    }
}