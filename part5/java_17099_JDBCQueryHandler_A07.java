import java.sql.*;

public class java_17099_JDBCQueryHandler_A07 {
    // Define the database URL, username, and password
    private static final String DB_URL = "jdbc:mysql://localhost:3306/mydb";
    private static final String USER = "root";
    private static final String PASS = "password";

    // Define the query
    private static final String SQL_SELECT = "SELECT * FROM Employees WHERE id = ?";

    public static void main(String[] args) {
        try {
            // Load the driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Open a connection
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);

            // Prepare the statement
            PreparedStatement pstmt = conn.prepareStatement(SQL_SELECT);
            pstmt.setInt(1, 1); // set the id

            // Execute the statement
            ResultSet rs = pstmt.executeQuery();

            // Process the result set
            while (rs.next()) {
                System.out.println(rs.getString("name"));
            }

            // Close the connection
            rs.close();
            pstmt.close();
            conn.close();
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}