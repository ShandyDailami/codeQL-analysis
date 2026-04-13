import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class java_35856_SessionManager_A08 {

    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        Connection connection = null;
        PreparedStatement pstmt = null;

        try {
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/testdb", "username", "password");

            String sql = "INSERT INTO USERS(USER_ID, USERNAME, PASSWORD) VALUES (?, ?, ?)";
            pstmt = connection.prepareStatement(sql);

            pstmt.setInt(1, 1);
            pstmt.setString(2, "TESTUSER");
            pstmt.setString(3, "TESTPASSWORD");

            pstmt.executeUpdate();

            System.out.println("Insert successful!");

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (pstmt != null) {
                try {
                    pstmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}