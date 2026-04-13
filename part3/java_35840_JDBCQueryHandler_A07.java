import java.sql.*;

public class java_35840_JDBCQueryHandler_A07 {
    private static final String url = "jdbc:mysql://localhost:3306/mydb";
    private static final String user = "myuser";
    private static final String password = "mypassword";

    public static void main(String[] args) {
        try {
            Connection conn = DriverManager.getConnection(url, user, password);
            Statement stmt = conn.createStatement();

            // Security sensitive operation: Authentication
            String authQuery = "SELECT * FROM Users WHERE username = '" + args[0] + "' AND password = '" + args[1] + "'";
            ResultSet rs = stmt.executeQuery(authQuery);
            if (!rs.next()) {
                System.out.println("Authentication failed");
                return;
            }

            // Security sensitive operation: Authorization
            String query = "SELECT * FROM Employees";
            rs = stmt.executeQuery(query);
            while (rs.next()) {
                System.out.println("Name: " + rs.getString("name"));
            }

            stmt.close();
            conn.close();
        } catch (SQLException e) {
            System.out.println("Error connecting to database: " + e.getMessage());
        }
    }
}