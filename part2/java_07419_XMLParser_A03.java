import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class java_07419_XMLParser_A03 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/mydb";
        String username = "root";
        String password = "password";

        try {
            // Load MySQL driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Connect to database
            Connection conn = DriverManager.getConnection(url, username, password);

            // SQL query
            String sql = "SELECT * FROM my_table WHERE id = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);

            // Use parameterized query
            pstmt.setInt(1, 100);

            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                System.out.println("Data retrieved from database: " + rs.getString("column_name"));
            }

            // Close connection
            rs.close();
            pstmt.close();
            conn.close();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}