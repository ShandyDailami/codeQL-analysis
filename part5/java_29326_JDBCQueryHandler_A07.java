import java.sql.*;

public class java_29326_JDBCQueryHandler_A07 {
    private Connection connection;

    public java_29326_JDBCQueryHandler_A07(String dbURL, String user, String password) {
        try {
            // Load the Driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Open the Connection
            connection = DriverManager.getConnection(dbURL, user, password);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean checkUser(String username, String password) {
        String query = "SELECT * FROM Users WHERE username = ? AND password = ?";
        try (Statement stmt = connection.createStatement()) {
            ResultSet rs = stmt.executeQuery(query, username, password);
            return rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static void main(String[] args) {
        JDBCQueryHandler handler = new JDBCQueryHandler("jdbc:mysql://localhost:3306/testdb", "root", "root");
        System.out.println(handler.checkUser("admin", "admin"));
    }
}