import java.sql.*;

public class java_17986_JDBCQueryHandler_A01 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/test";
        String username = "root";
        String password = "password";

        try {
            // Step 1: Establish a connection
            Connection conn = DriverManager.getConnection(url, username, password);

            // Step 2: Prepare a statement
            Statement stmt = conn.createStatement();

            // Step 3: Execute the query
            ResultSet rs = stmt.executeQuery("SELECT * FROM Users");

            // Step 4: Process the result
            while (rs.next()) {
                String name = rs.getString("name");
                String email = rs.getString("email");
                System.out.println("Name: " + name);
                System.out.println("Email: " + email);
            }

            // Step 5: Close the connection
            rs.close();
            stmt.close();
            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}