import java.sql.*;

public class java_03361_JDBCQueryHandler_A01 {
    // Database credentials
    private static final String DB_USERNAME = "username";
    private static final String DB_PASSWORD = "password";
    private static final String DB_URL = "jdbc:mysql://localhost:3306/testdb";

    // JDBC driver name and database URL
    private static final String DB_DRIVER = "com.mysql.jdbc.Driver";

    // Constructor to initialize the database connection
    public java_03361_JDBCQueryHandler_A01() {
        initializeDB();
    }

    // Initialize database connection
    private void initializeDB() {
        try {
            Class.forName(DB_DRIVER);
            Connection con = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
            // Create a statement
            Statement stmt = con.createStatement();
            // Execute a query
            ResultSet rs = stmt.executeQuery("SELECT * FROM USERS");
            // Extract data from result set
            while (rs.next()) {
                String name = rs.getString("name");
                int age = rs.getInt("age");
                // Print data
                System.out.println("Name: " + name + ", Age: " + age);
            }
            // Close database connection
            rs.close();
            stmt.close();
            con.close();
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new JDBCQueryHandler();
    }
}