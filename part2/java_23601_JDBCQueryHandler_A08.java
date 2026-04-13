import java.sql.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class java_23601_JDBCQueryHandler_A08 {
    private static final String URL = "jdbc:mysql://localhost:3306/test";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        try {
            Connection connection = getConnection();
            String password = "password"; // this is a hashed version of the password
            String sql = "INSERT INTO Users (Username, Password) VALUES (?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, "testUser");
            // You need to hash the password before inserting it into the database
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] hashPassword = md.digest(password.getBytes());
            statement.setBytes(2, hashPassword);
            statement.executeUpdate();
            statement.close();
            connection.close();
        } catch (SQLException | NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    private static Connection getConnection() throws SQLException, NoSuchAlgorithmException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}