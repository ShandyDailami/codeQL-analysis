import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class java_35623_JDBCQueryHandler_A01 {
    private static final String URL = "<your_database_url>";
    private static final String USERNAME = "<your_username>";
    private static final String PASSWORD = "<your_password>";

    private Connection connection;

    public void connect() throws SQLException {
        connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }

    public void disconnect() throws SQLException {
        connection.close();
    }

    public void executeQuery(String query) throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query);
        while (resultSet.next()) {
            System.out.println(resultSet.getString(1)); // Assuming the query selects a single string column
        }
        resultSet.close();
        statement.close();
    }

    public static void main(String[] args) throws SQLException, NoSuchAlgorithmException {
        JDBCQueryHandler handler = new JDBCQueryHandler();
        handler.connect();
        handler.executeQuery("SELECT * FROM users WHERE password='" + hashPassword("test") + "'");
        handler.disconnect();
    }

    public static String hashPassword(String password) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        byte[] hash = md.digest(password.getBytes());
        return bytesToHex(hash);
    }

    private static String bytesToHex(byte[] hash) {
        StringBuilder hexString = new StringBuilder();
        for (int i = 0; i < hash.length; i++) {
            String hex = Integer.toHexString(0xff & hash[i]);
            if(hex.length() == 1) hexString.append('0');
            hexString.append(hex);
        }
        return hexString.toString();
    }
}