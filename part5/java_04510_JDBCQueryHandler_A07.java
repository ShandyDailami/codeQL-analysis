import java.sql.*;

public class java_04510_JDBCQueryHandler_A07 {
    private int id;
    private String username;
    private String password;

    public java_04510_JDBCQueryHandler_A07(int id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}

public class UserDAO {
    private Connection connection;

    public java_04510_JDBCQueryHandler_A07(Connection connection) {
        this.connection = connection;
    }

    public User getUser(String username, String password) throws SQLException {
        String query = "SELECT * FROM users WHERE username = ? AND password = ?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, username);
        statement.setString(2, password);

        ResultSet result = statement.executeQuery();

        if (result.next()) {
            return new User(result.getInt(1), result.getString(2), result.getString(3));
        }

        return null;
    }
}