import java.sql.*;

public class java_29739_JDBCQueryHandler_A01 {
    // Database url
    private static final String DB_URL = "jdbc:mysql://localhost:3306/mydb";

    // Database credentials
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    private Connection conn;

    public java_29739_JDBCQueryHandler_A01() {
        try {
            conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            if (conn != null) {
                System.out.println("Connected to database");
            } else {
                System.out.println("Failed to connect to database");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void executeQuery(String query) {
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                System.out.println("User ID: " + rs.getString("id"));
                System.out.println("User Name: " + rs.getString("name"));
            }
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        VanillaJDBCQueryHandler handler = new VanillaJDBCQueryHandler();
        handler.executeQuery("SELECT * FROM Users");
    }
}