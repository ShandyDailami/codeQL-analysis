import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class java_14335_JDBCQueryHandler_A08 {
    public static void main(String[] args) {
        // Step 1: Set up connection to database
        Connection conn = null;
        Statement stmt = null;
        try {
            String url = "jdbc:mysql://localhost:3306/mydb";
            String username = "username";
            String password = "password";
            conn = DriverManager.getConnection(url, username, password);

            // Step 2: Create statement and execute query
            stmt = conn.createStatement();
            String sql = "SELECT * FROM mytable";
            ResultSet rs = stmt.executeQuery(sql);

            // Step 3: Handle ResultSet
            while (rs.next()) {
                String id = rs.getString("id");
                String name = rs.getString("name");
                System.out.println("id: " + id + ", name: " + name);
            }

            // Step 4: Close connections
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}