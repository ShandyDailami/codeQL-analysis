import java.sql.*;

public class java_25605_JDBCQueryHandler_A01 {
    private static final String DB_DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost:3306/mydb";
    private static final String USER = "root";
    private static final String PASS = "password";

    private Connection conn = null;
    private Statement stmt = null;
    private ResultSet rs = null;

    public java_25605_JDBCQueryHandler_A01() {
        try {
            Class.forName(DB_DRIVER);
            this.conn = DriverManager.getConnection(DB_URL, USER, PASS);
            this.stmt = this.conn.createStatement();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void execute(String query) {
        try {
            this.rs = this.stmt.executeQuery(query);
            while (this.rs.next()) {
                // handle each result row
                System.out.println(this.rs.getString("column_name"));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            // close resources
            try { if(this.rs != null) this.rs.close(); } catch(Exception ex) {}
            try { if(this.stmt != null) this.stmt.close(); } catch(Exception ex) {}
            try { if(this.conn != null) this.conn.close(); } catch(Exception ex) {}
        }
    }

    public static void main(String[] args) {
        JDBCQueryHandler handler = new JDBCQueryHandler();
        handler.execute("SELECT * FROM users WHERE username='" + args[0] + "' AND password='" + args[1] + "'");
    }
}