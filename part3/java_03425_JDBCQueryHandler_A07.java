import java.sql.*;
import java.util.Scanner;

public class java_03425_JDBCQueryHandler_A07 {

    private static final String url = "jdbc:mysql://localhost:3306/mydb";
    private static final String username = "root";
    private static final String password = "password";

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter your username:");
        String userInput = scanner.nextLine();

        System.out.println("Please enter your password:");
        String passwordInput = scanner.nextLine();

        try {
            // Step 1: Connect to the database
            Connection connection = DriverManager.getConnection(url, username, password);

            // Step 2: Create a statement
            Statement statement = connection.createStatement();

            // Step 3: Execute a query to get the hashed password
            ResultSet resultSet = statement.executeQuery("SELECT password FROM users WHERE username = '" + userInput + "'");

            if (resultSet.next()) {
                String hashedPassword = resultSet.getString(1);

                // Step 4: Compare the input password with the stored hashed password
                if (hashedPassword.equals(getHashedPassword(passwordInput))) {
                    System.out.println("Login successful!");
                } else {
                    System.out.println("Login failed, incorrect password!");
                }
            } else {
                System.out.println("Login failed, user not found!");
            }

            // Step 5: Close the connection
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Method to hash the password
    private static String getHashedPassword(String password) {
        // This is a simple hashing example using MD5. In a real-world application, you should use a more secure hash function like bcrypt.
        return javax.xml.crypto.dsig.signature.Signature.getMD5Digest().addDigestBytes(password.getBytes()).toString();
    }
}