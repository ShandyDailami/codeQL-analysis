import java.sql.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class java_13374_JDBCQueryHandler_A03 {

    public static void main(String[] args) {
        String url = "jdbc:your_database_url";
        String username = "your_username";
        String password = "your_password";

        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            String sql = "SELECT password FROM users";
            PreparedStatement statement = connection.prepareStatement(sql);

            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                String dbPassword = resultSet.getString("password");
                String inputPassword = hashPassword(password); // Assumes input password is hashed

                if (inputPassword.equals(dbPassword)) {
                    System.out.println("Password match found");
                } else {
                    System.out.println("Password didn't match");
                }
            }

            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static String hashPassword(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hash = md.digest(password.getBytes());
            return new String(hash);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }
}