import java.sql.*;

public class java_08253_JDBCQueryHandler_A03 {
    private Connection connection;

    public java_08253_JDBCQueryHandler_A03(String url, String username, String password) {
        try {
            this.connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ResultSet executeQuery(String query) {
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            return resultSet;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void executeUpdate(String query) {
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        // Inject URL, Username, and Password in a safe way (not recommended for production code)
        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String username = "myusername";
        String password = "mypassword";

        JDBCQueryHandler handler = new JDBCQueryHandler(url, username, password);

        // Example: Select all users
        String query = "SELECT * FROM users";
        ResultSet resultSet = handler.executeQuery(query);

        while (resultSet.next()) {
            String name = resultSet.getString("name");
            String email = resultSet.getString("email");
            System.out.println("Name: " + name);
            System.out.println("Email: " + email);
        }

        // Example: Insert a new user
        query = "INSERT INTO users (name, email) VALUES ('John Doe', 'john@example.com')";
        handler.executeUpdate(query);
    }
}