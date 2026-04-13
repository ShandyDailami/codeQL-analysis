import java.sql.*;

public class java_36240_JDBCQueryHandler_A08 {
    private static final String URL = "jdbc:mysql://localhost:3306/test";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        try {
            // Step 1: Register MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Step 2: Open a connection
            Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);

            // Step 3: Execute a query
            Statement stmt = conn.createStatement();
            String sql = "SELECT * FROM Users WHERE UserID = 'Admin' AND Password = 'password'";
            ResultSet rs = stmt.executeQuery(sql);

            // Step 4: Handle the ResultSet
            while (rs.next()) {
                String userID = rs.getString("UserID");
                String password = rs.getString("Password");
                System.out.println("UserID: " + userID);
                System.out.println("Password: " + password);
           
                // Step 5: Check for integrity failure
                if (userID.equals("Admin") && password.equals("password")) {
                    System.out.println("Integrity failure detected!");
                } else {
                    System.out.println("No integrity failure detected.");
                }
            }

            // Step 6: Close the ResultSet and the connection
            rs.close();
            conn.close();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}