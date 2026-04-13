import java.sql.*;

public class java_15390_JDBCQueryHandler_A01 {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/mydatabase";
    private static final String USER = "myuser";
    private static final String PASS = "mypassword";

    public static void main(String[] args) {
        try {
            Connection con = DriverManager.getConnection(DB_URL, USER, PASS);
            String sql = "UPDATE my_table SET my_column = ? WHERE user_id = ?";
            PreparedStatement pstmt = con.prepareStatement(sql);

            // Setting the parameters and executing the statement
            pstmt.setInt(1, 1000); // New value
            pstmt.setInt(2, 1); // User ID
            pstmt.executeUpdate();

            // Closing the connection
            pstmt.close();
            con.close();

        } catch (SQLException e) {
            System.out.println("Error connecting to database: " + e.getMessage());
        }
    }
}