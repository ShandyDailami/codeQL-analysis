import java.sql.*;

public class java_00914_JDBCQueryHandler_A01 {
    private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost:3306/mydatabase";
    private static final String USER = "root";
    private static final String PASS = "password";

    public static void main(String[] args) {
        Connection con = null;
        Statement stmt = null;
        try {
            // Load MySQL JDBC Driver
            Class.forName(JDBC_DRIVER);

            // Connect to database
            con = DriverManager.getConnection(DB_URL, USER, PASS);

            // Create a statement
            stmt = con.createStatement();

            // Execute the query
            String sql = "SELECT * FROM myTable";
            ResultSet rs = stmt.executeQuery(sql);

            // Handle the ResultSet
            while (rs.next()) {
                System.out.println("Found: " + rs.getString("myColumn"));
            }
            rs.close();
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Finally block used to close resources
            try {
                if (stmt != null)
                    stmt.close();
            } catch (SQLException se2) {
                se2.printStackTrace();
            }
            try {
                if (con != null)
                    con.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
    }
}