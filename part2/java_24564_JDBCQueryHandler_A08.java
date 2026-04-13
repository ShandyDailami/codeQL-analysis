import java.sql.*;

public class java_24564_JDBCQueryHandler_A08 {
    private static final String URL = "jdbc:mysql://localhost:3306/mydatabase";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        try {
            connectDB();
        } catch (SQLException e) {
            System.out.println("Error connecting to database: " + e.getMessage());
        }
    }

    private static void connectDB() throws SQLException {
        DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
        try (Connection con = DriverManager.getConnection(URL, USER, PASSWORD)) {
            String query = "SELECT * FROM table WHERE integrity_failure = true";
            try (Statement stmt = con.createStatement();
                 ResultSet rs = stmt.executeQuery(query)) {
                while (rs.next()) {
                    String name = rs.getString("name");
                    // handle data
                }
            }
        } catch (SQLException e) {
            System.out.println("Error handling database operations: " + e.getMessage());
        }
    }
}