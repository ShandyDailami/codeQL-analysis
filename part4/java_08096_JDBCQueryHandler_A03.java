import java.sql.*;

public class java_08096_JDBCQueryHandler_A03 {
    // DB Params
    private static final String DB_URL = "jdbc:mysql://localhost:3306/mydb";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    // Creating Connection
    public static Connection getConnection() {
        Connection con = null;
        try {
            con = DriverManager.getConnection(DB_URL, USER, PASSWORD);
        } catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
            System.exit(0);
       
        }
        return con;
    }

    // Simple CRUD Operations

    // Creating a new User
    public static void createUser(String name, String email) {
        String query = "INSERT INTO Users(name, email) VALUES(?,?)";
        try (Connection con = getConnection();
             PreparedStatement pstmt = con.prepareStatement(query)) {
            pstmt.setString(1, name);
            pstmt.setString(2, email);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Reading User
    public static void readUser() {
        String query = "SELECT id, name, email FROM Users";
        try (Connection con = getConnection();
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                String name = rs.getString("name");
                String email = rs.getString("email");
                System.out.println("Name: " + name + ", Email: " + email);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Updating User
    public static void updateUser(String name, String email) {
        String query = "UPDATE Users SET email = ? WHERE name = ?";
        try (Connection con = getConnection();
             PreparedStatement pstmt = con.prepareStatement(query)) {
            pstmt.setString(1, email);
            pstmt.setString(2, name);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Delete User
    public static void deleteUser(String name) {
        String query = "DELETE FROM Users WHERE name = ?";
        try (Connection con = getConnection();
             PreparedStatement pstmt = con.prepareStatement(query)) {
            pstmt.setString(1, name);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        // Create User
        createUser("John", "john@example.com");

        // Read Users
        readUser();

        // Update User
        updateUser("John", "johnny@example.com");

        // Delete User
        deleteUser("John");
    }
}