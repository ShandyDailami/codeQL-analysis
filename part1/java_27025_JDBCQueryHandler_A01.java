import java.sql.*;

public class java_27025_JDBCQueryHandler_A01 {
    private static final String URL = "jdbc:mysql://localhost:3306/test";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        // Query 1: Insert a user
        String query1 = "INSERT INTO Users (username, password, email) VALUES (?, ?, ?)";
        try (Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement pst = con.prepareStatement(query1)) {
            pst.setString(1, "user1");
            pst.setString(2, "password1");
            pst.setString(3, "user1@example.com");
            pst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // Query 2: Retrieve a user
        String query2 = "SELECT * FROM Users WHERE username = ?";
        try (Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement pst = con.prepareStatement(query2)) {
            pst.setString(1, "user1");
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                System.out.println("User found: " + rs.getString("username"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // Query 3: Update a user
        String query3 = "UPDATE Users SET password = ? WHERE username = ?";
        try (Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement pst = con.prepareStatement(query3)) {
            pst.setString(1, "newpassword");
            pst.setString(2, "user1");
            pst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // Query 4: Delete a user
        String query4 = "DELETE FROM Users WHERE username = ?";
        try (Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement pst = con.prepareStatement(query4)) {
            pst.setString(1, "user1");
            pst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}