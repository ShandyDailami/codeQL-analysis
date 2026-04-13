import java.sql.*;

public class java_06909_JDBCQueryHandler_A03 {

    public static void main(String[] args) {
        String url = "jdbc:sqlite:test.db";
        String selectSQL = "SELECT * from USERS";

        try (Connection conn = DriverManager.getConnection(url);
             Statement stmt = conn.createStatement()) {

            ResultSet rs = stmt.executeQuery(selectSQL);

            while (rs.next()) {
                String userID = rs.getString("userid");
                String userName = rs.getString("username");
                String userEmail = rs.getString("useremail");

                System.out.println("userID = " + userID);
                System.out.println("userName = " + userName);
                System.out.println("userEmail = " + userEmail);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}