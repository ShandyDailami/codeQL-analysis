import java.sql.*;

public class java_39570_JDBCQueryHandler_A08 {

    private static final String DB_URL = "jdbc:mysql://localhost:3306/testdb";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        try {
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            Statement stmt = conn.createStatement();

            // Create table
            String createTableSQL = "CREATE TABLE users (id INT PRIMARY KEY, username VARCHAR(50), password VARCHAR(50))";
            stmt.executeUpdate(createTableSQL);

            // Insert data
            String insertSQL = "INSERT INTO users (id, username, password) VALUES (1, 'user1', 'pass1')";
            stmt.executeUpdate(insertSQL);

            // Query data
            String selectSQL = "SELECT * FROM users";
            ResultSet rs = stmt.executeQuery(selectSQL);

            while (rs.next()) {
                int id = rs.getInt("id");
                String username = rs.getString("username");
                String password = rs.getString("password");

                System.out.println("id: " + id);
                System.out.println("username: " + username);
                System.out.println("password: " + password);
            }

            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}