import java.sql.*;

public class java_21674_JDBCQueryHandler_A08 {
    private static final String URL = "jdbc:mysql://localhost:3306/test";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        try {
            Connection conn = getConnection();
            if (conn != null) {
                try {
                    performQuery(conn);
                } finally {
                    conn.close();
                }
            } else {
                System.out.println("Failed to connect to the database");
            }
        } catch (SQLException e) {
            System.out.println("Error while connecting to the database: " + e.getMessage());
        }
    }

    private static Connection getConnection() {
        try {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            System.out.println("Error while connecting to the database: " + e.getMessage());
            return null;
        }
    }

    private static void performQuery(Connection conn) {
        String query = "SELECT * FROM A08_IntegrityFailure";
        try (Statement stmt = conn.createStatement()) {
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                System.out.println("Found a row: " + rs.getString("column1"));
            }
        } catch (SQLException e) {
            System.out.println("Error while executing the query: " + e.getMessage());
        }
    }
}