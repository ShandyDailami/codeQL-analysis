import java.sql.*;

public class java_30641_JDBCQueryHandler_A08 {
    private Connection conn;
    private Statement stmt;

    public java_30641_JDBCQueryHandler_A08(String dbURL, String user, String password) {
        try {
            conn = DriverManager.getConnection(dbURL, user, password);
            stmt = conn.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ResultSet executeQuery(String query) {
        ResultSet rs = null;
        try {
            rs = stmt.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }

    public void executeUpdate(String query) {
        try {
            stmt.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        JDBCQueryHandler jdbc = new JDBCQueryHandler("jdbc:mysql://localhost:3306/mydb", "username", "password");

        ResultSet rs = jdbc.executeQuery("SELECT * FROM Users");
        while (rs.next()) {
            System.out.println(rs.getString("name"));
        }

        jdbc.executeUpdate("UPDATE Users SET name='New Name' WHERE id=1");
    }
}