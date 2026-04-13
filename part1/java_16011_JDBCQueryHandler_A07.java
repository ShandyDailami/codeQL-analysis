import java.sql.*;

public class java_16011_JDBCQueryHandler_A07 {

    private String url;
    private String username;
    private String password;

    public java_16011_JDBCQueryHandler_A07(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    public void authenticateUser(String username, String password) throws SQLException {
        // Prepare the statement
        String SQL_SELECT_USER = "SELECT * FROM Users WHERE username = ?";
        PreparedStatement stmt = this.connection.prepareStatement(SQL_SELECT_USER);
        stmt.setString(1, username);

        // Execute the statement and get the result set
        ResultSet rs = stmt.executeQuery();

        // Verify if user exists and password is correct
        if (rs.next() && rs.getString("password").equals(password)) {
            System.out.println("User authenticated successfully!");
        } else {
            throw new SQLException("Invalid username or password");
        }
    }

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, username, password);
    }
}