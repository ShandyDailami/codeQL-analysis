import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class java_23731_JDBCQueryHandler_A07 {
    private static final String url = "jdbc:mysql://localhost:3306/dbname";
    private static final String username = "username";
    private static final String password = "password";

    public static void main(String[] args) {
        String query = "SELECT * FROM users WHERE username = ?";

        try (Connection con = DriverManager.getConnection(url, username, password);
             PreparedStatement ps = con.prepareStatement(query)) {

            ps.setString(1, "exampleUser"); // Replace "exampleUser" with the actual user's username

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                System.out.println("User exists and password is correct");
            } else {
                System.out.println("User does not exist or password is incorrect");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}