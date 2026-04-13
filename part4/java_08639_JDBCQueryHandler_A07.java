import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class java_08639_JDBCQueryHandler_A07 {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String username = "myuser";
        String password = "mypassword";

        try (Connection conn = DriverManager.getConnection(url, username, password);
             PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM mytable WHERE id = ?")) {

            // set the value for the parameter
            pstmt.setInt(1, 123);

            // execute the statement
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                System.out.println("Found user: " + rs.getString("username"));
            }
        } catch (SQLException ex) {
            System.out.println("Error occurred in JDBCQueryHandler: " + ex.getMessage());
        }
    }
}