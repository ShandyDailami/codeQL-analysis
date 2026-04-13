import java.sql.*;
import org.mindrot.jbcrypt.*;

public class java_01595_JDBCQueryHandler_A03 {

    private static final String url = "jdbc:mysql://localhost:3306/mydb";
    private static final String username = "root";
    private static final String password = "root";

    public static void main(String[] args) {
        createTable();
        storePassword();
        verifyPassword();
    }

    private static void createTable() {
        String createTableSql = "CREATE TABLE users (id INT PRIMARY KEY, password VARCHAR(255))";
        try (Connection connection = DriverManager.getConnection(url, username, password);
             Statement statement = connection.createStatement()) {
            statement.executeUpdate(createTableSql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void storePassword() {
        String password = "securepassword";
        String hashedPassword = BCrypt.hashpw(password, BCrypt.gensalt());
        String insertSql = "INSERT INTO users (id, password) VALUES (1, ?)";
        try (Connection connection = DriverManager.getConnection(url, username, password);
             PreparedStatement preparedStatement = connection.prepareStatement(insertSql)) {
            preparedStatement.setString(1, hashedPassword);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void verifyPassword() {
        String storedPassword = "";
        String suppliedPassword = "securepassword";
        try (Connection connection = DriverManager.getConnection(url, username, password);
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT password FROM users WHERE id = 1")) {
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                storedPassword = resultSet.getString(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        boolean passwordMatch = BCrypt.checkpw(suppliedPassword, storedPassword);
        System.out.println("Password Match: " + passwordMatch);
    }
}