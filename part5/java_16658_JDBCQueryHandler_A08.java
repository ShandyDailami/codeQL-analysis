import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class java_16658_JDBCQueryHandler_A08 {

    private Connection connection;

    // Method to establish the connection
    public void connect() {
        String url = "jdbc:mysql://localhost:3306/test";
        String username = "root";
        String password = "password";

        try {
            this.connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Method to close the connection
    public void disconnect() {
        try {
            this.connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Method to insert a new user into the database
    public void insertUser(String username, String password) {
        String query = "INSERT INTO user_table (username, password) VALUES (?, ?)";

        try {
            PreparedStatement statement = this.connection.prepareStatement(query);
            statement.setString(1, username);
            statement.setString(2, password);
            statement.executeUpdate();

            System.out.println("User inserted successfully");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Method to fetch the inserted user from the database
    public void fetchUser() {
        String query = "SELECT * FROM user_table WHERE username = ?";

        try {
            PreparedStatement statement = this.connection.prepareStatement(query);
            statement.setString(1, "username");
            ResultSet result = statement.executeQuery();

            if (result.next()) {
                System.out.println("Username: " + result.getString("username"));
                System.out.println("Password: " + result.getString("password"));
            } else {
                System.out.println("No user found with the given username");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Main method to run the program
    public static void main(String[] args) {
        JDBCQueryHandler handler = new JDBCQueryHandler();
        handler.connect();

        handler.insertUser("username", "password");
        handler.fetchUser();

        handler.disconnect();
    }
}