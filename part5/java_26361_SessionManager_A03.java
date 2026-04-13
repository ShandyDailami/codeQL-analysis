import java.sql.*;

public class java_26361_SessionManager_A03 {
    private static SessionManager instance = null;
    private Connection conn = null;
    private Statement stmt = null;

    private java_26361_SessionManager_A03() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            this.conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb", "username", "password");
            this.stmt = this.conn.createStatement();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static SessionManager getInstance() {
        if (instance == null) {
            instance = new SessionManager();
        }
        return instance;
    }

    public ResultSet executeQuery(String query) {
        ResultSet rs = null;
        try {
            rs = this.stmt.executeQuery(query);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return rs;
    }

    public int executeUpdate(String query) {
        int rows = 0;
        try {
            rows = this.stmt.executeUpdate(query);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return rows;
    }

    public void closeConnection() {
        try {
            if (this.stmt != null)
                this.stmt.close();
            if (this.conn != null)
                this.conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}