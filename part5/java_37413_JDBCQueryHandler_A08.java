import java.sql.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class java_37413_JDBCQueryHandler_A08 {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/test";
    private static final String USER = "root";
    private static final String PASS = "password";

    public static void main(String[] args) {
        try {
            // Step 1: Establish a connection
            Connection connection = DriverManager.getConnection(DB_URL, USER, PASS);

            // Step 2: Prepare a statement
            String query = "SELECT * FROM users WHERE username = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, "user1"); // Replace with the actual username

            // Step 3: Execute the query
            ResultSet resultSet = preparedStatement.executeQuery();

            // Step 4: Process the result
            while (resultSet.next()) {
                String passwordDB = resultSet.getString("password");
                String inputPassword = "password"; // Replace with the actual password

                // Step 5: Check if the passwords match
                if (isPasswordMatch(passwordDB, inputPassword)) {
                    System.out.println("Login successful!");
                } else {
                    System.out.println("Wrong password!");
                }
            }

            // Step 6: Clean up
            resultSet.close();
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static boolean isPasswordMatch(String passwordDB, String inputPassword) {
        try {
            // Step 7: Hash the input password
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hash = md.digest(inputPassword.getBytes());

            // Step 8: Compare the hash with the hash from the database
            return Arrays.equals(hash, passwordDB.getBytes());
        } catch (NoSuchAlgorithmException | SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}