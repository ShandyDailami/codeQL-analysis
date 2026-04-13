import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class java_03609_SessionManager_A01 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/testdb";
        String user = "root";
        String password = "password";

        try {
            // Step 1: Register JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Step 2: Establish a connection
            Connection connection = DriverManager.getConnection(url, user, password);

            // Step 3: Prepare a statement
            String query = "INSERT INTO sessions (value) VALUES (?)";
            PreparedStatement pstmt = connection.prepareStatement(query);

            // Step 4: Set the parameter value
            pstmt.setString(1, "Hello, World!");

            // Step 5: Execute the statement
            pstmt.executeUpdate();

            // Step 6: Retrieve the result
            ResultSet rs = pstmt.executeQuery("SELECT * FROM sessions WHERE id = 1");
            if (rs.next()) {
                String value = rs.getString("value");
                System.out.println("Retrieved value: " + value);
            }

            // Step 7: Close the connection
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}