import java.sql.*;

public class java_01713_JDBCQueryHandler_A08 {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/test";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    private static Connection connection;

    // Establish a connection
    private static Connection establishConnection() {
        try {
            connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            System.out.println("Connected to the database");
        } catch (SQLException e) {
            System.out.println("Failed to connect to the database");
            e.printStackTrace();
        }
        return connection;
    }

    // Execute a SQL query
    public static void executeQuery(String query) {
        try {
            Connection conn = establishConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                System.out.println(rs.getString("name"));
            }
        } catch (SQLException e) {
            System.out.println("Failed to execute query");
            e.printStackTrace();
        }
    }

    // Execute a SQL update
    public static void executeUpdate(String query) {
        try {
            Connection conn = establishConnection();
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(query);
            System.out.println("Update completed successfully");
        } catch (SQLException e) {
            System.out.println("Failed to execute update");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        // Create a new user
        String createUser = "INSERT INTO users (name) VALUES ('John')";
        executeUpdate(createUser);

        // Retrieve the new user
        String retrieveUser = "SELECT * FROM users WHERE name = 'John'";
        executeQuery(retrieveUser);
    }
}