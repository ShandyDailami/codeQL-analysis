import java.sql.*;

public class java_18422_JDBCQueryHandler_A08 {

    private static final String DB_URL = "jdbc:mysql://localhost:3306/mydb";
    private static final String USER = "root";
    private static final String PASS = "password";

    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;

        try {
            // Step 1: Establish a connection to the database
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Connected to the database");

            // Step 2: Create a statement object
            stmt = conn.createStatement();
            System.out.println("Statement object created");

            // Step 3: Execute a query
            ResultSet rs = stmt.executeQuery("SELECT * FROM users");
            System.out.println("Results: ");

            // Step 4: Process the result set
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String email = rs.getString("email");

                System.out.println("ID: " + id);
                System.out.println("Name: " + name);
                System.out.println("Email: " + email);
            }

            // Step 5: Close the connection
            rs.close();
            stmt.close();
            conn.close();
            System.out.println("Connection closed");

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Step 6: Cleanup
            try {
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}