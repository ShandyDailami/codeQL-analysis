import java.sql.*;

public class java_01158_JDBCQueryHandler_A03 {
    private Connection conn;
    private Statement stmt;

    public java_01158_JDBCQueryHandler_A03() {
        try {
            // Load the Driver
            Class.forName("com.mysql.jdbc.Driver");

            // Establish the Connection
            conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/mydb", "username", "password");

            // Create a Statement
            stmt = conn.createStatement();
        } catch (SQLException e) {
            System.out.println("Failed to connect to the database: " + e.getMessage());
        }
    }

    public ResultSet executeQuery(String query) {
        ResultSet rs = null;
        try {
            // Execute the Query
            rs = stmt.executeQuery(query);
        } catch (SQLException e) {
            System.out.println("Failed to execute query: " + e.getMessage());
        }

        return rs;
    }

    public void executeUpdate(String query) {
        try {
            stmt.executeUpdate(query);
        } catch (SQLException e) {
            System.out.println("Failed to execute update: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        JDBCQueryHandler handler = new JDBCQueryHandler();
        ResultSet rs = handler.executeQuery("SELECT * FROM Users");

        try {
            while (rs.next()) {
                System.out.println(rs.getString("username"));
            }
        } catch (SQLException e) {
            System.out.println("Failed to iterate over ResultSet: " + e.getMessage());
        }
    }
}