import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class java_05043_JDBCQueryHandler_A03 {

    // This method connects to the database
    public Connection connect(String url, String username, String password) {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            System.out.println("SQLException occurred: " + e.getMessage());
        }
        return conn;
    }

    // This method inserts a new user into the database
    public void insertUser(Connection conn, String username, String password) {
        String sql = "INSERT INTO Users (username, password) VALUES (?, ?)";
        try {
            conn.prepareStatement(sql).executeUpdate();
        } catch (SQLException e) {
            System.out.println("SQLException occurred: " + e.getMessage());
        }
    }

    // This method fetches a user from the database
    public void fetchUser(Connection conn, String username) {
        String sql = "SELECT * FROM Users WHERE username = ?";
        try {
            conn.prepareStatement(sql).executeQuery();
        } catch (SQLException e) {
            System.out.println("SQLException occurred: " + e.getMessage());
        }
    }

    // This method updates a user in the database
    public void updateUser(Connection conn, String username, String password) {
        String sql = "UPDATE Users SET password = ? WHERE username = ?";
        try {
            conn.prepareStatement(sql).executeUpdate();
        } catch (SQLException e) {
            System.out.println("SQLException occurred: " + e.getMessage());
        }
    }

    // This method deletes a user from the database
    public void deleteUser(Connection conn, String username) {
        String sql = "DELETE FROM Users WHERE username = ?";
        try {
            conn.prepareStatement(sql).executeUpdate();
        } catch (SQLException e) {
            System.out.println("SQLException occurred: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/mydb";
        String username = "root";
        String password = "password";

        JDBCQueryHandler jdbcQueryHandler = new JDBCQueryHandler();
        Connection conn = jdbcQueryHandler.connect(url, username, password);

        // Uncomment the following lines to insert, fetch, update, and delete a user
        // jdbcQueryHandler.insertUser(conn, "newuser", "newpassword");
        // jdbcQueryHandler.fetchUser(conn, "newuser");
        // jdbcQueryHandler.updateUser(conn, "newuser", "newpassword");
        // jdbcQueryHandler.deleteUser(conn, "newuser");
    }
}