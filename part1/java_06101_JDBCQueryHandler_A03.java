import java.sql.*;

public class java_06101_JDBCQueryHandler_A03 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String username = "myusername";
        String password = "mypassword";

        try {
            // Step 1: Load the Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Step 2: Open a Connection
            Connection conn = DriverManager.getConnection(url, username, password);

            // Step 3: Write a Query
            String query = "SELECT * FROM my_table WHERE my_column = ?";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, "my_value"); // This is a security-sensitive operation

            // Step 4: Execute the Query
            ResultSet rs = pstmt.executeQuery();

            // Step 5: Process the ResultSet
            while (rs.next()) {
                String columnValue = rs.getString("my_column");
                // Do something with the columnValue
            }

            // Step 6: Close the Connection
            conn.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}