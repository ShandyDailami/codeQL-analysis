import java.sql.*;

public class java_20149_JDBCQueryHandler_A07 {
    private Connection conn = null;
    private Statement stmt = null;

    public java_20149_JDBCQueryHandler_A07(String dbURL, String dbUsername, String dbPassword) {
        try {
            conn = DriverManager.getConnection(dbURL, dbUsername, dbPassword);
            stmt = conn.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void authenticateUser(String username, String password) {
        String query = "SELECT * FROM USERS WHERE USERNAME ='" + username + "' AND PASSWORD ='" + password + "'";
        try {
            ResultSet rs = stmt.executeQuery(query);
            if (rs.next()) {
                System.out.println("Authentication successful!");
            } else {
                System.out.println("Authentication failed!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        JDBCQueryHandler handler = new JDBCQueryHandler("jdbc:mysql://localhost:3306/mydb", "root", "password");
        handler.authenticateUser("username", "password");
    }
}