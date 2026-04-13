import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class java_14513_SessionManager_A03 {

    private Connection connection;

    public java_14513_SessionManager_A03(String url, String username, String password) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // MySQL driver
            this.connection = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public void create(String sql) {
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ResultSet read(String sql) {
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            return statement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void update(String sql) {
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(String sql) {
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void close() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager("jdbc:mysql://localhost:3306/test", "username", "password");

        // Create
        sessionManager.create("INSERT INTO users (name, email) VALUES (?, ?)");

        // Read
        ResultSet resultSet = sessionManager.read("SELECT * FROM users WHERE name=?");
        while (resultSet.next()) {
            String name = resultSet.getString("name");
            String email = resultSet.getString("email");
            System.out.println("Name: " + name + ", Email: " + email);
        }

        // Update
        sessionManager.update("UPDATE users SET email=? WHERE name=?");

        // Delete
        sessionManager.delete("DELETE FROM users WHERE name=?");

        sessionManager.close();
    }
}