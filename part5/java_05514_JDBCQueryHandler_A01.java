import java.sql.*;

public class java_05514_JDBCQueryHandler_A01 {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/mydatabase";
    private static final String USER = "root";
    private static final String PASS = "password";

    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;

        try {
            // Load the driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Open a connection
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            // Create a statement
            stmt = conn.createStatement();

            // Execute the query
            ResultSet rs = stmt.executeQuery("SELECT * FROM Users WHERE username='" + args[0] + "' AND password='" + args[1] + "'");

            // Process the result set
            while (rs.next()) {
                System.out.println("Found user: " + rs.getString("username"));
            }

            // Close the connection
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
       
        } finally {
            //finally block used to close resources
            try {
                if(stmt != null)
                    conn.close();
            } catch(SQLException sqlse){
                sqlse.printStackTrace();
            }
        }
    }
}