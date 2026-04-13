import java.sql.*;

public class java_11841_JDBCQueryHandler_A01 {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/test";
    private static final String USER = "root";
    private static final String PASS = "password";

    public static void main(String[] args) {
        try {
            // Open a connection
            Connection con = DriverManager.getConnection(DB_URL, USER, PASS);

            // Create a statement
            Statement stmt = con.createStatement();

            // Execute a SQL query
            ResultSet rs = stmt.executeQuery("SELECT * FROM Users WHERE username='admin' AND password='password'");

            // Process the results
            while (rs.next()) {
                System.out.println("User Found!");
            }

            // Close the connection
            rs.close();
            stmt.close();
            con.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}