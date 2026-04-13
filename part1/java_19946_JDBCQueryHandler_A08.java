import java.sql.*;

public class java_19946_JDBCQueryHandler_A08 {
    private Connection conn;
    private Statement stmt;
    private ResultSet rs;

    private static final String URL = "jdbc:mysql://localhost:3306/db_name";
    private static final String USER = "root";
    private static final String PASS = "password";

    public java_19946_JDBCQueryHandler_A08() {
        try {
            conn = DriverManager.getConnection(URL, USER, PASS);
            stmt = conn.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void performIntegrityFailureOperation(String query) {
        try {
            rs = stmt.executeQuery(query);
            while (rs.next()) {
                System.out.println("Result: " + rs.getString(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
    }

    private void closeConnection() {
        try {
            if (rs != null) rs.close();
            if (stmt != null) stmt.close();
            if (conn != null) conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        JDBCQueryHandler handler = new JDBCQueryHandler();
        handler.performIntegrityFailureOperation("SELECT * FROM employees WHERE id = '" + args[0] + "'");
    }
}