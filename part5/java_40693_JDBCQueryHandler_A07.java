import java.sql.*;

public class java_40693_JDBCQueryHandler_A07 {
    private Connection conn;

    public java_40693_JDBCQueryHandler_A07() {
        try {
            conn = DriverManager.getConnection("jdbc:sqlite:test.db");
            System.out.println("Connection to SQLite has been established.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void executeQuery(String query) {
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                System.out.println(rs.getString("username") + " - " + rs.getString("password"));
            }
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void executeUpdate(String query) {
        try {
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(query);
            System.out.println("Update Successful.");
            stmt.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        new VanillaJavaJDBCQueryHandler();
        String createTable = "CREATE TABLE users (username TEXT, password TEXT)";
        String insertUser = "INSERT INTO users (username, password) VALUES ('user1', 'password1')";
        String selectUser = "SELECT * FROM users";
        new VanillaJavaJDBCQueryHandler().executeUpdate(createTable);
        new VanillaJavaJDBCQueryHandler().executeUpdate(insertUser);
        new VanillaJavaJDBCQueryHandler().executeQuery(selectUser);
    }
}