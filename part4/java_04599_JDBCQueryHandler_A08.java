import java.sql.*;

public class java_04599_JDBCQueryHandler_A08 {
    private static final String url = "jdbc:mysql://localhost:3306/mydatabase";
    private static final String username = "username";
    private static final String password = "password";

    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;

        try {
            // Step 1: Establish a connection to the database
            conn = DriverManager.getConnection(url, username, password);

            // Step 2: Prepare the statement
            stmt = conn.createStatement();

            // Step 3: Execute the SQL query
            String sql = "INSERT INTO Users (username, password) VALUES ('newuser', 'newpassword')";
            stmt.executeUpdate(sql);

            // Step 4: Retrieve all users
            ResultSet rs = stmt.executeQuery("SELECT * FROM Users");

            // Step 5: Process the result set
            while (rs.next()) {
                System.out.println(rs.getString("username"));
            }

            // Step 6: Close the connection
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}