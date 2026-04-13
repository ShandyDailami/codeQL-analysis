import java.sql.*;

public class java_18781_JDBCQueryHandler_A07 {
    private static final String url = "jdbc:mysql://localhost:3306/mydb";
    private static final String username = "root";
    private static final String password = "root";

    public static void main(String[] args) {
        try {
            // Step 1: Establish a Connection
            Connection conn = DriverManager.getConnection(url, username, password);

            // Step 2: Prepare a Statement
            Statement stmt = conn.createStatement();

            // Step 3: Execute a Query
            ResultSet rs = stmt.executeQuery("SELECT * FROM Users");

            // Step 4: Process the ResultSet
            while (rs.next()) {
                String userId = rs.getString("userId");
                String password = rs.getString("password");
                System.out.println("User ID: " + userId);
                System.out.println("Password: " + password);
            }

            // Step 5: Close the Connection
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}