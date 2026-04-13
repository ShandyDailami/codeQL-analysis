import java.sql.*;

public class java_39780_JDBCQueryHandler_A01 {

    // database credentials
    private static final String DB_URL = "jdbc:mysql://localhost:3306/testdb";
    private static final String USER = "root";
    private static final String PASS = "password";

    // create a connection
    private Connection conn;

    public java_39780_JDBCQueryHandler_A01() {
        try {
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // example of a query handler method
    public void handleQuery() {
        try {
            Statement stmt = conn.createStatement();
            String sql = "SELECT * FROM users WHERE email = 'test@test.com'";
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                String email = rs.getString("email");
                String password = rs.getString("password");
                System.out.println("Email: " + email);
                System.out.println("Password: " + password);
            }

            rs.close();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        VanillaJDBCQueryHandler handler = new VanillaJDBCQueryHandler();
        handler.handleQuery();
    }
}