import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class java_24238_JDBCQueryHandler_A07 {
    private Connection connection;

    public java_24238_JDBCQueryHandler_A07(String url, String username, String password) {
        try {
            connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    public void executeQuery(String query, Object[] parameters, ResultHandler handler) {
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            for (int i = 0; i < parameters.length; i++) {
                statement.setObject(i + 1, parameters[i]);
            }
            handler.handle(statement.executeQuery());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public interface ResultHandler {
        void handle(ResultSet resultSet) throws SQLException;
    }
}

public class Main {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/testdb";
        String username = "username";
        String password = "password";

        JDBCQueryHandler handler = new JDBCQueryHandler(url, username, password);

        String query = "SELECT * FROM users WHERE username = ?";
        String usernameParam = "testuser";

        handler.executeQuery(query, new Object[] { usernameParam }, resultSet -> {
            while (resultSet.next()) {
                String password = resultSet.getString("password");
                // Perform security-sensitive operations with the password here
            }
        });
    }
}