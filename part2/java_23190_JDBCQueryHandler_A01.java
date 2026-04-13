import java.sql.*;

public class java_23190_JDBCQueryHandler_A01 {
    private static final String URL = "jdbc:mysql://localhost:3306/mydatabase";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        // Query 1: Accessing data
        query1();

        // Query 2: Updating data
        query2();

        // Query 3: Deleting data
        query3();

        // Query 4: Inserting data
        query4();
    }

    private static void query1() {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            String sql = "SELECT * FROM Users WHERE username = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, "admin");
            ResultSet result = statement.executeQuery();

            while (result.next()) {
                System.out.println(result.getString("password"));
            }
        } catch (SQLException e) {
            System.out.println("Error accessing data: " + e.getMessage());
        }
    }

    private static void query2() {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            String sql = "UPDATE Users SET password = ? WHERE username = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, "newpassword");
            statement.setString(2, "admin");
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error updating data: " + e.getMessage());
        }
    }

    private static void query3() {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            String sql = "DELETE FROM Users WHERE username = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, "admin");
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error deleting data: " + e.getMessage());
        }
    }

    private static void query4() {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            String sql = "INSERT INTO Users (username, password) VALUES (?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, "newuser");
            statement.setString(2, "newpassword");
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error inserting data: " + e.getMessage());
        }
    }
}