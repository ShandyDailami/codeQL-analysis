import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class java_18881_SessionManager_A03 {

    private static ThreadLocal<Connection> threadLocal = new ThreadLocal<Connection>() {
        @Override
        protected Connection initialValue() {
            Connection conn = null;
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb", "root", "password");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            return conn;
        }
    };

    public Connection getConnection() {
        return threadLocal.get();
    }

    public void closeConnection(Connection conn) {
        threadLocal.remove();
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        SessionManager sm = new SessionManager();
        Connection conn = sm.getConnection();

        // do some DB operations here

        sm.closeConnection(conn);
    }
}