import java.sql.*;

public class java_04517_JDBCQueryHandler_A08 {
    private String username;
    private String password;

    public java_04517_JDBCQueryHandler_A08(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}

public class Password {
    private String password;

    public java_04517_JDBCQueryHandler_A08(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }
}

public class DatabaseManager {
    private Connection connection;

    public java_04517_JDBCQueryHandler_A08() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/mydatabase", "username", "password");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public boolean authenticateUser(User user) {
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM Users WHERE username = ?");
            statement.setString(1, user.getUsername());
            ResultSet result = statement.executeQuery();

            if (result.next()) {
                Password dbPassword = result.getString("password");
                return dbPassword.getPassword().equals(user.getPassword());
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return false;
    }
}

public class Main {
    public static void main(String[] args) {
        DatabaseManager dbManager = new DatabaseManager();
        User user = new User("user1", "password");
        System.out.println(dbManager.authenticateUser(user));
    }
}