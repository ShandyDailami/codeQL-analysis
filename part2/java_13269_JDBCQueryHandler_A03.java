import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class java_13269_JDBCQueryHandler_A03 {
    public static void main(String[] args) {
        String url = "jdbc:postgresql://your_host:port/db_name";
        String username = "your_username";
        String password = "your_password";

        try (Connection conn = DriverManager.getConnection(url, username, password)) {
            String query = "SELECT * FROM table_name WHERE column_name = ?";
            try (PreparedStatement pstmt = conn.prepareStatement(query)) {
                pstmt.setString(1, "value_to_check"); // Replace "value_to_check" with the value you want to check

                try (ResultSet rs = pstmt.executeQuery()) {
                    if (rs.next()) {
                        // Handle the result set if needed
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}