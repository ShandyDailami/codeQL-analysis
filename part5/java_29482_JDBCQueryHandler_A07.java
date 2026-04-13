import java.sql.*;

public class java_29482_JDBCQueryHandler_A07 {
    private static final String URL = "jdbc:mysql://localhost:3306/mydb";
    private static final String USER = "myuser";
    private static final String PASS = "mypass";

    public static void main(String[] args) {
        try {
            Connection conn = DriverManager.getConnection(URL, USER, PASS);
            Statement stmt = conn.createStatement();

            // Start by creating a new user
            String createUserQuery = "INSERT INTO Users (username, password) VALUES ('user1', 'password1')";
            stmt.executeUpdate(createUserQuery);

            // Then check if the user exists
            String checkUserQuery = "SELECT * FROM Users WHERE username = 'user1'";
            ResultSet rs = stmt.executeQuery(checkUserQuery);

            if (rs.next()) {
                // User exists
                System.out.println("User exists!");
            } else {
                // User does not exist
                System.out.println("User does not exist!");
            }

            // Finally, close the connection
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}