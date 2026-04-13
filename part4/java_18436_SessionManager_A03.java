import javax.management.Query;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class java_18436_SessionManager_A03 {

    private List<Connection> pool;
    private int poolSize;

    public java_18436_SessionManager_A03(int size) {
        this.poolSize = size;
        this.pool = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            this.pool.add(this.createConnection());
        }
    }

    private Connection createConnection() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "user", "password");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    public Connection getConnection() {
        if (this.pool.isEmpty()) {
            return this.createConnection();
        } else {
            Connection conn = this.pool.remove(0);
            if (conn == null) {
                return this.createConnection();
            }
            return conn;
        }
    }

    public void releaseConnection(Connection conn) {
        this.pool.add(conn);
    }

    public ResultSet executeQuery(String query) {
        Connection conn = this.getConnection();
        ResultSet rs = null;
        try {
            rs = conn.createStatement().executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            this.releaseConnection(conn);
        }
        return rs;
    }
}