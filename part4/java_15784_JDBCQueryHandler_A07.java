import java.sql.*;
import java.util.Properties;

public class java_15784_JDBCQueryHandler_A07 {

    private static final String DB_DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost:3306/mydb";
    private static final String USER = "root";
    private static final String PASS = "password";

    private Connection conn = null;
    private Statement stmt = null;
    private ResultSet rs = null;

    private void connectToDB() {
        try {
            Class.forName(DB_DRIVER);
            this.conn = DriverManager.getConnection(DB_URL, USER, PASS);
            this.stmt = this.conn.createStatement();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void disconnectFromDB() {
        try {
            if (this.stmt != null) {
                this.stmt.close();
            }
            if (this.conn != null) {
                this.conn.close();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void executeQuery(String query) {
        try {
            if (this.conn != null) {
                this.rs = this.stmt.executeQuery(query);
                while (this.rs.next()) {
                    // TODO: Handle the result set
                }
            } else {
                connectToDB();
                this.rs = this.stmt.executeQuery(query);
                while (this.rs.next()) {
                    // TODO: Handle the result set
                }
                disconnectFromDB();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        JDBCQueryHandler jdbcQueryHandler = new JDBCQueryHandler();
        jdbcQueryHandler.executeQuery("SELECT * FROM Users");
    }
}