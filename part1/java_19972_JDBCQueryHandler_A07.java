import java.sql.*;

public class java_19972_JDBCQueryHandler_A07 {

    private String url;
    private String username;
    private String password;

    public java_19972_JDBCQueryHandler_A07(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    public boolean authenticateUser(String username, String password) {
        boolean isAuthenticated = false;

        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            System.out.println("Connected to the database!");

            // Here you can add your SQL Query. For example, checking if a user exists in the database.
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM users WHERE username ='" + username + "'");

            if (resultSet.next()) {
                isAuthenticated = true;
            }

        } catch (SQLException e) {
            System.out.println("Authentication failed!");
            e.printStackTrace();
        }

        return isAuthenticated;
    }

}