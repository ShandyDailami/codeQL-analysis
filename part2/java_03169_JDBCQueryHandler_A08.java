import java.sql.*;

public class java_03169_JDBCQueryHandler_A08 {
    // Hard-coded username and password for simplicity. In real-world application,
    // these should be obtained from a configuration file or secured vault.
    private static final String USER = "user";
    private static final String PASS = "pass";
    private static final String URL = "jdbc:mysql://localhost:3306/test";

    public static void main(String[] args) {
        try {
            // Step 1: Load the driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Step 2: Open a connection
            Connection conn = DriverManager.getConnection(URL, USER, PASS);

            // Step 3: Prepare a statement
            String query = "SELECT * FROM Users WHERE id = ?";
            PreparedStatement pstmt = conn.prepareStatement(query);

            // Step 4: Set parameter and execute the statement
            pstmt.setInt(1, 123); // Set the parameter value
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                System.out.println("User Found!");
                System.out.println("ID: " + rs.getInt("id"));
                System.out.println("Name: " + rs.getString("name"));
            }

            // Step 5: Close the connection
            rs.close();
            pstmt.close();
            conn.close();

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}