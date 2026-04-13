import java.sql.*;

public class java_41280_JDBCQueryHandler_A01 {

    // Static user list for authentication
    private static final String USERS_DB = "users";

    // User and password details for authentication
    private static final String USER_DB = "user";
    private static final String PASSWORD_DB = "password";

    public static void main(String[] args) {
        executeQuery();
    }

    private static void executeQuery() {
        String url = "jdbc:mysql://localhost:3306/" + USERS_DB;
        String driver = "com.mysql.cj.jdbc.Driver";

        try {
            Class.forName(driver);
            System.out.println("Connecting to database...");
            Connection connection = DriverManager.getConnection(url, USER_DB, PASSWORD_DB);

            System.out.println("Connection successful!");
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM users");

            // Check for user and password in the database
            while (rs.next()) {
                String dbUser = rs.getString("username");
                String dbPassword = rs.getString("password");
                if (dbUser.equals(USER_DB) && dbPassword.equals(PASSWORD_DB)) {
                    System.out.println("Access granted!");
                    return;
                }
            }

            System.out.println("Access denied!");
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}