import java.sql.*;

public class java_24803_JDBCQueryHandler_A08 {
    private static final String URL = "jdbc:mysql://localhost:3306/testdb";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    private Connection conn = null;
    private Statement stmt = null;

    private void connect() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            stmt = conn.createStatement();
        } catch (Exception ex) {
            System.out.println("Error in connection: " + ex.getMessage());
        }
    }

    private void disconnect() {
        try {
            if (stmt != null) stmt.close();
            if (conn != null) conn.close();
        } catch (Exception ex) {
            System.out.println("Error in disconnection: " + ex.getMessage());
        }
    }

    public void performQuery(String query) {
        connect();
        try {
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id"));
                System.out.println("Name: " + rs.getString("name"));
                System.out.println("Email: " + rs.getString("email"));
            }
        } catch (SQLException ex) {
            System.out.println("Error in query execution: " + ex.getMessage());
        }
        disconnect();
    }
}