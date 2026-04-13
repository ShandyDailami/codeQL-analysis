import java.sql.*;

public class java_29881_JDBCQueryHandler_A07 {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/mydatabase";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;

        try {
            conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            stmt = conn.createStatement();

            // Create a new table
            String createTableSQL = "CREATE TABLE Users" +
                    "(id INT PRIMARY KEY," +
                    "username VARCHAR(50)," +
                    "password VARCHAR(50))";
            stmt.executeUpdate(createTableSQL);

            // Insert a new row
            String insertSQL = "INSERT INTO Users(id, username, password) VALUES(1, 'test', 'test')";
            stmt.executeUpdate(insertSQL);

            // Select a row
            String selectSQL = "SELECT * FROM Users WHERE id = 1";
            ResultSet rs = stmt.executeQuery(selectSQL);

            while (rs.next()) {
                String username = rs.getString("username");
                String password = rs.getString("password");

                System.out.println("Username: " + username);
                System.out.println("Password: " + password);
            }

            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}