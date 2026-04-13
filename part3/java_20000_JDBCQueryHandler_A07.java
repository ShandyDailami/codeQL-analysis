import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class java_20000_JDBCQueryHandler_A07 {

    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/testdb";
        String username = "root";
        String password = "password";
        String driverName = "com.mysql.cj.jdbc.Driver";

        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            System.out.println("Connection successful!");

            String query = "SELECT * FROM Users WHERE username = ?";

            try (java.sql.PreparedStatement pstmt = connection.prepareStatement(query)) {
                pstmt.setString(1, "bob"); // Example user
                java.sql.ResultSet rs = pstmt.executeQuery();

                while (rs.next()) {
                    String usernameResult = rs.getString("username");
                    String passwordResult = rs.getString("password");
                    System.out.println("User: " + usernameResult + ", Password: " + passwordResult);
                }
            } catch (SQLException ex) {
                System.out.println("Error in execution: " + ex.getMessage());
            }

        } catch (ClassNotFoundException ex) {
            System.out.println("Driver not found: " + ex.getMessage());
        } catch (SQLException ex) {
            System.out.println("Connection failed: " + ex.getMessage());
        }
    }
}