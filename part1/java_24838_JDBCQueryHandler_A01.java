import java.sql.*;

public class java_24838_JDBCQueryHandler_A01 {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/mydatabase";
    private static final String USER = "root";
    private static final String PASS = "password";

    private Connection conn = null;
    private Statement stmt = null;
    private ResultSet rs = null;

    public java_24838_JDBCQueryHandler_A01() {
        try {
            // Step 1: Setup the connection
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            conn.setAutoCommit(false); // Enable transactions

            // Step 2: Prepare the statement
            stmt = conn.prepareStatement("SELECT * FROM Users WHERE id = ?");
            stmt.setInt(1, 123); // Use the id of the user to get data

            // Step 3: Execute the statement
            rs = stmt.executeQuery();

            // Step 4: Process the result
            while (rs.next()) {
                String name = rs.getString("name");
                String email = rs.getString("email");
                System.out.println("Name: " + name);
                System.out.println("Email: " + email);
            }

            // Step 5: Cleanup
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new JDBCQueryHandler();
    }
}