import java.sql.*;
import java.util.Properties;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class java_25173_JDBCQueryHandler_A07 {
    private Connection connection;

    public java_25173_JDBCQueryHandler_A07(String dbURL, String dbUsername, String dbPassword) throws SQLException {
        Properties props = new Properties();
        props.setProperty("user", dbUsername);
        props.setProperty("password", dbPassword);
        props.setProperty("ssl", "false");
        this.connection = DriverManager.getConnection(dbURL, props);
    }

    public ResultSet executeQuery(String query) throws SQLException {
        Statement stmt = this.connection.createStatement();
        return stmt.executeQuery(query);
    }

    public void executeUpdate(String update) throws SQLException {
        Statement stmt = this.connection.createStatement();
        stmt.executeUpdate(update);
    }

    public String hashPassword(String password) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        byte[] hash = md.digest(password.getBytes());
        return new String(hash);
    }
}