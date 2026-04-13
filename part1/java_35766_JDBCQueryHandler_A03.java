import java.sql.*;

public class java_35766_JDBCQueryHandler_A03 {

    // You may want to use a static username and password for security reasons
    private static final String USER = "username";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;

        try {
            // Step 1: Establish a connection
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb", USER, PASSWORD);

            // Step 2: Prepare a statement
            stmt = conn.createStatement();

            // Step 3: Execute a query
            ResultSet rs = stmt.executeQuery("SELECT * FROM test_table");

            // Step 4: Process the result
            while (rs.next()) {
                String id = rs.getString("id");
                String name = rs.getString("name");
                System.out.println("ID: " + id + ", Name: " + name);
            }

            // Step 5: Close the statement and connection
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}