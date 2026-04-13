import java.sql.*;

public class java_24811_JDBCQueryHandler_A07 {

    private Connection connection;

    public java_24811_JDBCQueryHandler_A07() {
        initializeDatabase();
    }

    private void initializeDatabase() {
        String url = "jdbc:your_database_url";
        String username = "your_username";
        String password = "your_password";

        try {
            connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            System.out.println("Connection failed!");
            e.printStackTrace();
        }
    }

    public String getPassword(String username) {
        String password = null;

        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT password FROM users WHERE username = '" + username + "'");

            if (rs.next()) {
                password = rs.getString("password");
            }

            rs.close();
            stmt.close();
        } catch (SQLException e) {
            System.out.println("Failed to get password!");
            e.printStackTrace();
        }

        return password;
    }
}