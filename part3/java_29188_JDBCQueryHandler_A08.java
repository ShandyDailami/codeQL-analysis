import java.sql.*;

public class java_29188_JDBCQueryHandler_A08 {

    private Connection conn;

    public java_29188_JDBCQueryHandler_A08() {
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb", "username", "password");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void executeQuery(String query) {
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                System.out.println(rs.getString("name"));
            }

            rs.close();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void executeUpdate(String query) {
        try {
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(query);
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        VanillaJavaJDBCQueryHandler handler = new VanillaJavaJDBCQueryHandler();
        handler.executeQuery("SELECT * FROM users");
    }
}