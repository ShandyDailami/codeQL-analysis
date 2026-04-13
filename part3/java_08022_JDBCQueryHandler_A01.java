import java.sql.*;

public class java_08022_JDBCQueryHandler_A01 {
    private Connection conn;
    private Statement stmt;

    public java_08022_JDBCQueryHandler_A01(String url, String username, String password) {
        try {
            conn = DriverManager.getConnection(url, username, password);
            stmt = conn.createStatement();
        } catch (SQLException e) {
            System.out.println("Error connecting to database");
            e.printStackTrace();
        }
    }

    public void executeQuery(String query) {
        try {
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                // Printing the data fetched from the database
                System.out.println(rs.getString("data"));
            }
        } catch (SQLException e) {
            System.out.println("Error executing query");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        JDBCQueryHandler handler = new JDBCQueryHandler("jdbc:mysql://localhost:3306/testdb", "username", "password");
        handler.executeQuery("SELECT * FROM Users");
    }
}