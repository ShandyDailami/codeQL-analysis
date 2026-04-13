import java.sql.*;

public class java_04790_JDBCQueryHandler_A01 {
    private static Connection conn = null;
    private static Statement stmt = null;

    // Method to establish a connection
    private static void createConnection() {
        String url = "jdbc:mysql://localhost:3306/testdb";
        String username = "root";
        String password = "password";

        try {
            conn = DriverManager.getConnection(url, username, password);
            stmt = conn.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Method to close the connection and statement
    private static void closeConnection() {
        try {
            if (stmt != null)
                stmt.close();
            if (conn != null)
                conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Method to execute a SELECT query
    public static void selectQuery(String query) {
        createConnection();

        try {
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                System.out.println(rs.getString("Column1"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        closeConnection();
    }

    // Method to execute a INSERT query
    public static void insertQuery(String query) {
        createConnection();

        try {
            stmt.executeUpdate(query);
            System.out.println("Inserted successfully");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        closeConnection();
    }

    // Method to execute a DELETE query
    public static void deleteQuery(String query) {
        createConnection();

        try {
            stmt.executeUpdate(query);
            System.out.println("Deleted successfully");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        closeConnection();
    }

    // Method to execute a UPDATE query
    public static void updateQuery(String query) {
        createConnection();

        try {
            stmt.executeUpdate(query);
            System.out.println("Updated successfully");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        closeConnection();
    }
}