import java.sql.*;

public class java_01510_JDBCQueryHandler_A03 {
    // Database credentials
    private static final String url = "jdbc:mysql://localhost:3306/mydatabase";
    private static final String username = "myuser";
    private static final String password = "mypassword";

    public static void main(String[] args) {
        try {
            // Step 1: Load the driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Step 2: Establish a connection
            Connection con = DriverManager.getConnection(url, username, password);

            // Step 3: Execute a query
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM mytable");

            // Step 4: Process the result
            while (rs.next()) {
                System.out.println(rs.getString("mycolumn"));
            }

            // Step 5: Close the connection
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