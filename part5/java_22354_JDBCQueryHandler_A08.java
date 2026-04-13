import java.sql.*;

public class java_22354_JDBCQueryHandler_A08 {

    private static final String URL = "your_database_url";
    private static final String USER = "your_database_username";
    private static final String PASSWORD = "your_database_password";

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public void executeQuery(String query, Object[] params, Callback callback) {
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            for (int i = 0; i < params.length; i++) {
                statement.setObject(i + 1, params[i]);
            }
            callback.process(statement.executeQuery());
        } catch (SQLException e) {
            System.out.println("Error executing query: " + e.getMessage());
        }
    }

    public interface Callback {
        void process(ResultSet resultSet) throws SQLException;
    }
}

public class Main {
    public static void main(String[] args) {
        JDBCQueryHandler handler = new JDBCQueryHandler();

        String query = "SELECT * FROM Users WHERE email = ?";
        String email = "test@example.com";

        handler.executeQuery(query, new Object[]{email}, resultSet -> {
            try {
                if (resultSet.next()) {
                    System.out.println("User found!");
                } else {
                    System.out.println("No user found with email " + email);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        });
    }
}