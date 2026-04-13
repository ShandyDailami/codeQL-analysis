import java.sql.*;

public class java_05003_SessionManager_A01 {
    private Connection connection;

    public java_05003_SessionManager_A01(String url, String username, String password) throws SQLException {
        this.connection = DriverManager.getConnection(url, username, password);
    }

    public User getUser(int userId) throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM Users WHERE id = " + userId);

        if (resultSet.next()) {
            return new User(resultSet.getInt("id"), resultSet.getString("name"));
        }

        return null;
    }

    public void close() throws SQLException {
        connection.close();
    }

    public static class User {
        private int id;
        private String name;

        public java_05003_SessionManager_A01(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }
    }
}