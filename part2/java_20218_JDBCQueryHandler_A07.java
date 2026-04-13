import java.sql.*;

public class java_20218_JDBCQueryHandler_A07 {
    private static final String url = "jdbc:mysql://localhost:3306/mydb";
    private static final String username = "root";
    private static final String password = "password";

    private Connection conn;

    public java_20218_JDBCQueryHandler_A07() {
        try {
            conn = DriverManager.getConnection(url, username, password);
            System.out.println("Connected to database successfully!");
        } catch (SQLException e) {
            System.out.println("Failed to connect to database");
            e.printStackTrace();
            System.exit(-1);
        }
    }

    public ResultSet executeQuery(String query) {
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            return rs;
        } catch (SQLException e) {
            System.out.println("Error while executing query: " + e.getMessage());
        }
        return null;
    }

    public int executeUpdate(String query) {
        try {
            Statement stmt = conn.createStatement();
            return stmt.executeUpdate(query);
        } catch (SQLException e) {
            System.out.println("Error while executing update: " + e.getMessage());
        }
        return -1;
    }

    public static void main(String[] args) {
        VanillaJDBCQueryHandler handler = new VanillaJDBCQueryHandler();
        ResultSet rs = handler.executeQuery("SELECT * FROM users");
        while (rs.next()) {
            System.out.println(rs.getString("name"));
        }
        handler.executeUpdate("UPDATE users SET password = 'new_password' WHERE name = 'user'");
    }
}