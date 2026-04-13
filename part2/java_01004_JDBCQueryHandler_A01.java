import java.sql.*;

public class java_01004_JDBCQueryHandler_A01 {
    public static void main(String[] args) {
        // JDBC driver name and database URL
        String driver = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/mydatabase";

        // Database credentials
        String username = "username";
        String password = "password";

        try {
            // Load the driver
            Class.forName(driver);

            // Establish a connection
            Connection con = DriverManager.getConnection(url, username, password);

            // Create a statement
            Statement stmt = con.createStatement();

            // Execute the query
            ResultSet rs = stmt.executeQuery("SELECT * FROM mytable");

            // Extract data from result set
            while (rs.next()) {
                System.out.println(rs.getString("fieldname1") + ", " + rs.getString("fieldname2"));
            }

            // Close the connection
            rs.close();
            stmt.close();
            con.close();
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}