import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class java_13827_JDBCQueryHandler_A07 {

    public static void main(String[] args) {
        try {
            // Load the driver
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        // Connection string
        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String username = "myusername";
        String password = "mypassword";

        try (Connection conn = DriverManager.getConnection(url, username, password);
             Statement stmt = conn.createStatement()) {

            // Run a query
            ResultSet rs = stmt.executeQuery("SELECT * FROM mytable");

            // Handle the ResultSet
            while (rs.next()) {
                System.out.println(rs.getString("mycolumn"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}