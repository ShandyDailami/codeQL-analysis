import java.sql.*;

public class java_00576_JDBCQueryHandler_A07 {

    // Define the database credentials
    private static final String DB_URL = "jdbc:mysql://localhost:3306/mydatabase";
    private static final String USER = "username";
    private static final String PASS = "password";

    private static Connection conn = null;

    static {
        try {
            // Establish the database connection
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Method to perform a query
    public static ResultSet executeQuery(String query) {
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            return rs;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // Method to perform a update operation
    public static boolean executeUpdate(String query) {
        try {
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(query);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static void main(String[] args) {
        // Example of a query
        String query = "SELECT * FROM Employee WHERE id=1";
        ResultSet rs = executeQuery(query);
        try {
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id"));
                System.out.println("Name: " + rs.getString("name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // Example of an update operation
        String updateQuery = "UPDATE Employee SET name='John' WHERE id=1";
        if (executeUpdate(updateQuery)) {
            System.out.println("Update successful!");
        } else {
            System.out.println("Update failed.");
        }
    }
}