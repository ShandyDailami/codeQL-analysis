import java.sql.*;

public class java_00800_JDBCQueryHandler_A08 {

    // Driver name and database URL
    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/mydatabase";
    private static final String USER = "username";
    private static final String PASS = "password";

    public static void main(String[] args) {
        Connection con = null;
        Statement stmt = null;
        try {
            // Load MySQL driver
            Class.forName(DRIVER);

            // Open a connection
            con = DriverManager.getConnection(URL, USER, PASS);
            stmt = con.createStatement();

            // Test select query
            String sql = "SELECT * FROM Users";
            ResultSet rs = stmt.executeQuery(sql);

            // Extract and print data from result set
            while (rs.next()) {
                String name = rs.getString("name");
                int age = rs.getInt("age");
                System.out.println("Name: " + name);
                System.out.println("Age: " + age);
            }

            // Close connection
            rs.close();
            stmt.close();
            con.close();
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // finally block used to close resources
        }
    }
}