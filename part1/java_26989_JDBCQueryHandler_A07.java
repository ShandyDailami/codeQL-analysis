import java.sql.*;

public class java_26989_JDBCQueryHandler_A07 {
    private static final String URL = "jdbc:mysql://localhost:3306/mydb";
    private static final String USER = "username";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        try {
            // Step 1: Establish a Connection
            Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);

            // Step 2: Prepare a Statement
            Statement stmt = conn.createStatement();

            // Step 3: Execute a Query
            ResultSet rs = stmt.executeQuery("SELECT * FROM Users WHERE username = 'test' AND password = 'test'");

            // Step 4: Process the ResultSet
            while (rs.next()) {
                String username = rs.getString("username");
                String password = rs.getString("password");
                System.out.println("Username: " + username);
                System.out.println("Password: " + password);
            }

            // Step 5: Close the Connection
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}