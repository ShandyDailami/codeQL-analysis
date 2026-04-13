import java.sql.*;

public class java_40396_JDBCQueryHandler_A07 {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/mydb";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        try {
            // Step 1: Establish a connection
            conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);

            // Step 2: Create a statement
            stmt = conn.createStatement();

            // Step 3: Execute a SQL query
            String sql = "SELECT * FROM users WHERE id = " + args[0];
            ResultSet rs = stmt.executeQuery(sql);

            // Step 4: Process the result set
            while (rs.next()) {
                String name = rs.getString("name");
                String email = rs.getString("email");
                System.out.println("Name: " + name);
                System.out.println("Email: " + email);
            }

            // Step 5: Close the resources
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}