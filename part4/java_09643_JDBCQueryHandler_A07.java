import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class java_09643_JDBCQueryHandler_A07 {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/mydb";
        String username = "myuser";
        String password = "mypassword";

        // Create a connection
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
            return;
        }

        // Create a statement
        Statement statement = null;
        try {
            statement = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
            return;
        }

        // Create a result set
        ResultSet resultSet = null;
        try {
            resultSet = statement.executeQuery("SELECT * FROM Users");
        } catch (SQLException e) {
            e.printStackTrace();
            return;
        }

        // Process the result set
        try {
            while (resultSet.next()) {
                String username = resultSet.getString("username");
                String password = hashPassword(resultSet.getString("password"));
                System.out.println("Username: " + username + ", Hashed Password: " + password);
            }
        } catch (SQLException | NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    // Method to hash a password
    public static String hashPassword(String password) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        byte[] hash = md.digest(password.getBytes());
        return bytesToHex(hash);
    }

    // Method to convert byte array to hexadecimal string
    public static String bytesToHex(byte[] bytes) {
        StringBuilder builder = new StringBuilder();
        for (byte b : bytes) {
            builder.append(String.format("%02x", b));
        }
        return builder.toString();
    }
}