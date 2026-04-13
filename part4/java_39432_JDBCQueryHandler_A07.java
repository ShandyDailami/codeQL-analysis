import java.sql.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class java_39432_JDBCQueryHandler_A07 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/testdb";
        String username = "root";
        String password = "password";

        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            Statement statement = connection.createStatement();

            // Assume userID is 1 and password column is "password"
            ResultSet resultSet = statement.executeQuery("SELECT password FROM users WHERE id = 1");
            if (resultSet.next()) {
                String dbPassword = resultSet.getString("password");
                System.out.println("Password in the database: " + dbPassword);

                // Hash the user's password
                MessageDigest md = MessageDigest.getInstance("SHA-256");
                byte[] hash = md.digest(password.getBytes());

                // Compare the hash with the hashed password in the database
                if (Arrays.equals(hash, dbPassword)) {
                    System.out.println("Access granted!");
                } else {
                    System.out.println("Access denied!");
                }
            } else {
                System.out.println("No user found with the given ID!");
            }

            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}