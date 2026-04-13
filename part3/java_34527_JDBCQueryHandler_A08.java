import java.sql.*;

public class java_34527_JDBCQueryHandler_A08 {
    private static final String url = "jdbc:mysql://localhost:3306/mydatabase";
    private static final String username = "myusername";
    private static final String password = "mypassword";

    public static void main(String[] args) {
        try {
            // Step 1: Establish a connection to the database
            Connection conn = DriverManager.getConnection(url, username, password);

            // Step 2: Prepare a statement
            String query = "SELECT * FROM my_table WHERE id = ?";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, 123); // Set the value of the id

            // Step 3: Execute the query
            ResultSet rs = pstmt.executeQuery();

            // Step 4: Process the results
            while (rs.next()) {
                String name = rs.getString("name");
                System.out.println("Name: " + name);
            }

            // Step 5: Close the resources
            rs.close();
            pstmt.close();
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}