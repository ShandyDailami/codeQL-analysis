import java.sql.*;

public class java_13989_JDBCQueryHandler_A07 {
    // Database credentials
    private static final String DB_URL = "jdbc:mysql://localhost:3306/mydatabase";
    private static final String USER = "username";
    private static final String PASS = "password";

    // Create a connection
    private Connection getConnection() {
        Connection con = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(DB_URL, USER, PASS);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return con;
    }

    // Execute a query
    public ResultSet executeQuery(String query) {
        Connection con = null;
        ResultSet rs = null;
        try {
            con = getConnection();
            Statement stmt = con.createStatement();
            rs = stmt.executeQuery(query);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (con != null)
                    con.close();
            } catch (SQLException se) {
            }
        }
        return rs;
    }

    // Execute an update operation
    public int executeUpdate(String query) {
        Connection con = null;
        int rowsUpdated = 0;
        try {
            con = getConnection();
            Statement stmt = con.createStatement();
            rowsUpdated = stmt.executeUpdate(query);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (con != null)
                    con.close();
            } catch (SQLException se) {
            }
        }
        return rowsUpdated;
    }
}