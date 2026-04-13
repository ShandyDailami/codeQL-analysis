import java.sql.*;

public class java_12200_JDBCQueryHandler_A08 {
    private static final String URL = "jdbc:mysql://localhost:3306/test";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    private Connection conn;

    public java_12200_JDBCQueryHandler_A08() {
        try {
            this.conn = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            System.out.println("Failed to connect to the database. Error: " + e.getMessage());
        }
    }

    public void executeQuery(String query) {
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                System.out.println("ID: " + rs.getString("id"));
                System.out.println("Name: " + rs.getString("name"));
            }
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            System.out.println("Failed to execute query. Error: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        new JDBCQueryHandler();
    }
}