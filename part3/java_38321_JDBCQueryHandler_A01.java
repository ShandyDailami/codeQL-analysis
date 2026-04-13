import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class java_38321_JDBCQueryHandler_A01 {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/mydb";
        String username = "root";
        String password = "password";

        try {
            // Load MySQL driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Create connection
            Connection conn = DriverManager.getConnection(url, username, password);

            // Create statement
            Statement stmt = conn.createStatement();

            // Execute SQL query
            ResultSet rs = stmt.executeQuery("SELECT * FROM users WHERE role='admin'");

            // Process ResultSet
            while (rs.next()) {
                System.out.println(rs.getString("username"));
            }

            // Close connection
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}