import java.sql.*;

public class java_06213_JDBCQueryHandler_A07 {
    private Connection conn;

    public java_06213_JDBCQueryHandler_A07() {
        String url = "jdbc:mysql://localhost:3306/test";
        String username = "root";
        String password = "password";

        try {
            conn = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ResultSet executeQuery(String query) {
        try {
            Statement stmt = conn.createStatement();
            return stmt.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void executeUpdate(String query) {
        try {
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        JDBCQueryHandler handler = new JDBCQueryHandler();

        String query = "SELECT * FROM users WHERE email = ?";
        ResultSet rs = handler.executeQuery(query);

        try {
            while (rs.next()) {
                String email = rs.getString("email");
                String password = rs.getString("password");

                // This is a security sensitive operation. You should hash the password before saving it.
                // Please implement this part according to your requirement.

                System.out.println("Email: " + email);
                System.out.println("Password: " + password);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}