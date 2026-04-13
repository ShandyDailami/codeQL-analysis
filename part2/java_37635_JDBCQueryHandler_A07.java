import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class java_37635_JDBCQueryHandler_A07 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String username = "myuser";
        String password = "mypassword";

        try (Connection conn = DriverManager.getConnection(url, username, password);
             Statement stmt = conn.createStatement()) {

            // Assuming the user's password is stored in a column named 'password'
            String sql = "SELECT password FROM my_table WHERE username = 'myuser'";
            ResultSet rs = stmt.executeQuery(sql);

            if (rs.next()) {
                String passwordFromDB = rs.getString("password");
                System.out.println("Password from DB: " + passwordFromDB);
            } else {
                System.out.println("No user found!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}