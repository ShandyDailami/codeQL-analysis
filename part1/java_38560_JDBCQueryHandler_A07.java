import java.sql.*;

public class java_38560_JDBCQueryHandler_A07 {

    private static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost:3306/mydb";
    private static final String USER = "username";
    private static final String PASS = "password";

    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        try {
            Class.forName(JDBC_DRIVER);
            System.out.println("Connecting to database...\n");

            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            System.out.println("Connection Successful!!");
            System.out.println("Creating statement...\n");

            stmt = conn.createStatement();

            String SQL = "SELECT USER_ID FROM USERS WHERE USERNAME = \'" + args[0] + "\' AND PASSWORD = \'" + args[1] + "\'";

            ResultSet rs = stmt.executeQuery(SQL);

            while (rs.next()) {
                String userId = rs.getString("USER_ID");
                System.out.println("User ID: " + userId);
            }
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Close the resources in reverse order
            if (stmt != null) {
                try { stmt.close(); } catch (SQLException e) {}
            }
            if (conn != null) {
                try { conn.close(); } catch (SQLException e) {}
            }
        }
    }
}