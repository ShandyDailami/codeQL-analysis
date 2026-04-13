import java.sql.*;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class java_29297_JDBCQueryHandler_A03 {

    private static final String URL = "jdbc:mysql://localhost:3306/test";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    private BlockingQueue<Connection> connectionPool = new LinkedBlockingQueue<>();

    public java_29297_JDBCQueryHandler_A03() {
        try {
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
        } catch (SQLException e) {
            throw new ExceptionInInitializerError("Failed to initialize database connection pool.");
        }

        for (int i = 0; i < 5; i++) {
            try {
                Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
                connectionPool.put(conn);
            } catch (InterruptedException | SQLException e) {
                throw new ExceptionInInitializerError("Failed to initialize database connection pool.");
            }
        }
    }

    public Connection getConnection() throws InterruptedException {
        return connectionPool.take();
    }

    public void releaseConnection(Connection conn) {
        if (conn != null) {
            connectionPool.put(conn);
        }
    }

    public void executeQuery(String query, ResultHandler handler) {
        Connection conn = null;
        Statement stmt = null;
        try {
            conn = getConnection();
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            handler.handle(rs);
        } catch (SQLException | InterruptedException e) {
            e.printStackTrace();
        } finally {
            releaseConnection(conn);
        }
    }

    public void executeUpdate(String query) {
        Connection conn = null;
        Statement stmt = null;
        try {
            conn = getConnection();
            stmt = conn.createStatement();
            stmt.executeUpdate(query);
        } catch (SQLException | InterruptedException e) {
            e.printStackTrace();
        } finally {
            releaseConnection(conn);
        }
    }
}