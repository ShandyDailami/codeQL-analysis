import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class java_06382_JDBCQueryHandler_A08 {
    private static final String URL = "jdbc:mysql://localhost:3306/testdb";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        try {
            // Step 1: Load the MySQL driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Step 2: Establish a connection
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);

            // Step 3: Prepare a statement
            String query = "SELECT * FROM users WHERE username = ?";
            PreparedStatement statement = connection.prepareStatement(query);

            // Step 4: Set the parameter
            statement.setString(1, "user1");

            // Step 5: Execute the statement
            ResultSet resultSet = statement.executeQuery();

            // Step 6: Handle the result
            while (resultSet.next()) {
                String passwordInDB = resultSet.getString("password");
                String salt = resultSet.getString("salt");

                // Step 7: Verify the password
                String inputPassword = "password"; // This should be hashed and salted on the client side
                MessageDigest md = MessageDigest.getInstance("MD5");
                byte[] hash = md.digest(inputPassword.getBytes());
                String inputPasswordHash = bytesToHex(hash);

                if (passwordInDB.equals(inputPasswordHash)) {
                    System.out.println("Access granted");
                } else {
                    System.out.println("Access denied");
                }
            }

            // Step 8: Close the connection
            resultSet.close();
            statement.close();
            connection.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    private static String bytesToHex(byte[] bytes) {
        StringBuilder builder = new StringBuilder();
        for (byte b : bytes) {
            builder.append(String.format("%02x", b));
        }
        return builder.toString();
    }
}