import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class java_28725_JDBCQueryHandler_A01 {
    private String url;
    private String username;
    private String password;

    public java_28725_JDBCQueryHandler_A01(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    public String getPassword(String userId) throws SQLException, NoSuchAlgorithmException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            // Load the MySQL driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish a connection
            connection = DriverManager.getConnection(url, username, password);

            // Prepare a SQL query
            preparedStatement = connection.prepareStatement("SELECT password FROM users WHERE userId = ?");
            preparedStatement.setString(1, userId);

            // Execute the query
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                String dbPassword = resultSet.getString("password");

                // Compute a hash of the user's password using SHA-256
                MessageDigest md = MessageDigest.getInstance("SHA-256");
                byte[] bytes = md.digest(dbPassword.getBytes());

                // Return the hash as a hexadecimal string
                return bytesToHex(bytes);
            }
        } finally {
            if (resultSet != null) {
                resultSet.close();
            }
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }

        return null;
    }

    private String bytesToHex(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }
}