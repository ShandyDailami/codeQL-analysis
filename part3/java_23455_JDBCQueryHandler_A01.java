import java.sql.*;

public class java_23455_JDBCQueryHandler_A01 {
    private static final String url = "jdbc:oracle:thin:@localhost:1521:xe";
    private static final String user = "myuser";
    private static final String password = "mypassword";

    public static void main(String[] args) {
        try {
            // Step 1: Establish a connection
            Connection conn = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to the database!");

            // Step 2: Prepare a statement
            Statement stmt = conn.createStatement();
            ResultSet rs;

            // Step 3: Execute a query
            String sql = "SELECT * FROM USERS";
            rs = stmt.executeQuery(sql);

            // Step 4: Process the results
            while (rs.next()) {
                System.out.println("User: " + rs.getString("username"));
            }

            // Step 5: Clean up
            rs.close();
            stmt.close();
            conn.close();
            System.out.println("Disconnected from the database!");

        } catch (SQLException e) {
            System.out.println("Error connecting to the database!");
            e.printStackTrace();
        }
    }
}