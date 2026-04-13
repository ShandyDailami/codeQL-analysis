import java.sql.*;

public class java_21047_JDBCQueryHandler_A01 {
    private Connection conn;

    public java_21047_JDBCQueryHandler_A01(String dbURL, String userName, String password) throws SQLException {
        conn = DriverManager.getConnection(dbURL, userName, password);
    }

    public void executeQuery(String query) throws SQLException {
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(query);

        while (rs.next()) {
            System.out.println("ID: " + rs.getInt("id"));
            System.out.println("Name: " + rs.getString("name"));
            System.out.println("Email: " + rs.getString("email"));
        }

        rs.close();
        stmt.close();
    }

    public void executeUpdate(String query) throws SQLException {
        Statement stmt = conn.createStatement();
        stmt.executeUpdate(query);
        stmt.close();
    }

    public static void main(String[] args) {
        String dbURL = "jdbc:mysql://localhost:3306/mydb";
        String userName = "myuser";
        String password = "mypassword";

        try {
            JDBCQueryHandler handler = new JDBCQueryHandler(dbURL, userName, password);
            handler.executeQuery("SELECT * FROM Users");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}