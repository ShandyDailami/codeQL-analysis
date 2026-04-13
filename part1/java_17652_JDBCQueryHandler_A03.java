import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class java_17652_JDBCQueryHandler_A03 {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/mydb";
        String username = "root";
        String password = "password";

        try {
            // Step 1: Load MySQL Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Step 2: Establish a Connection
            Connection conn = DriverManager.getConnection(url, username, password);

            // Step 3: Prepare SQL Query with ? placeholders for values
            String sql = "INSERT INTO employees (name, role) VALUES (?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);

            // Step 4: Set value for ? placeholders
            pstmt.setString(1, "John Doe");
            pstmt.setString(2, "Developer");

            // Step 5: Execute SQL statement
            int affectedRows = pstmt.executeUpdate();

            System.out.println("Affected rows: " + affectedRows);

            // Step 6: Clean up
            pstmt.close();
            conn.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}