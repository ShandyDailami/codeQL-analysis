import java.sql.*;

public class java_13227_JDBCQueryHandler_A01 {
    private static final String URL = "jdbc:mysql://localhost:3306/testdb";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    private Connection conn;

    public void connect() {
        try {
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        // Handle the exception appropriately here
        }
    }

    public void query(String query) {
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                // Do something with the result set
            }

            rs.close();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        // Handle the exception appropriately here
        }
    }

    public static void main(String[] args) {
        JDBCQueryHandler handler = new JDBCQueryHandler();
        handler.connect();
        handler.query("SELECT * FROM users WHERE username = 'test'");
    }
}