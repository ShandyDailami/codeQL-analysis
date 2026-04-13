import java.sql.*;

public class java_19508_JDBCQueryHandler_A08 {

    // JDBC driver name and database URL
    private static final String DB_DRIVER = "com.mysql.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost:3306/mydb";

    // Database credentials
    private static final String USER = "root";
    private static final String PASS = "root";

    // Constructor
    public java_19508_JDBCQueryHandler_A08() {
        initializeDatabase();
    }

    // Method to initialize the database
    private void initializeDatabase() {
        Connection con = null;
        try {
            Class.forName(DB_DRIVER);
            con = DriverManager.getConnection(DB_URL, USER, PASS);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Close connection after use
        if (con != null) {
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    // Method to perform a query
    public void query(String query) {
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            con = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = con.createStatement();
            rs = stmt.executeQuery(query);

            // Display results
            while (rs.next()) {
                System.out.println("ID = " + rs.getString("id"));
                System.out.println("Name = " + rs.getString("name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Close connection after use
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}