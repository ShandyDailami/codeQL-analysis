import java.sql.*;
import java.util.*;

public class java_21731_SessionManager_A03 {
    private static HashMap<String, String> userMap;
    private static String encryptedPassword;
    private Connection connection;

    public java_21731_SessionManager_A03() {
        userMap = new HashMap<>();
        userMap.put("user1", "encryptedPassword1");
        userMap.put("user2", "encryptedPassword2");
    }

    public boolean authenticate(String username, String password) {
        encryptedPassword = userMap.get(username);
        if (encryptedPassword == null) {
            System.out.println("Invalid username");
            return false;
        }

        if (!encryptedPassword.equals(password)) {
            System.out.println("Invalid password");
            return false;
        }

        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "username", "password");
            System.out.println("Connected to the database");
            return true;
        } catch (SQLException e) {
            System.out.println("Error connecting to the database");
            return false;
        }
    }

    public void executeQuery(String query) {
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                System.out.println(resultSet.getString("name"));
            }

            connection.close();
        } catch (SQLException e) {
            System.out.println("Error executing query");
        }
    }
}