import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class java_06778_SessionManager_A03 {

    // The data source is the one that will provide us with a connection to the database
    private DataSource dataSource;

    public java_06778_SessionManager_A03() {
        try {
            // Here we assume we are using a JNDI name for our data source
            Context ctx = new InitialContext();
            dataSource = (DataSource) ctx.lookup("java:comp/env/jdbc/myDatabase");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Method to obtain a new database connection
    public Connection getConnection() {
        Connection conn = null;
        try {
            conn = dataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    // Method to close a connection
    public void closeConnection(Connection conn) {
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
        sm.closeConnection(conn);
    }
}