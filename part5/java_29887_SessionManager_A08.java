import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class java_29887_SessionManager_A08 {

    public static void main(String[] args) {
        try {
            // Step 1: Connect to the database
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "username", "password");

            // Step 2: Create a user
            String user = "testUser";
            String password = "password";

            // Step 3: Create a session
            Session session = new Session(connection);
            session.beginTransaction();

            // Step 4: Create a prepared statement
            String sql = "UPDATE users SET password = ? WHERE username = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, password);
            statement.setString(2, user);

            // Step 5: Execute the statement
            statement.executeUpdate();

            // Step 6: Commit the transaction
            session.commit();
            session.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

class Session {
    private Connection connection;

    public java_29887_SessionManager_A08(Connection connection) {
        this.connection = connection;
    }

    public void beginTransaction() {
        try {
            connection.setAutoCommit(false);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void commit() {
        try {
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void close() {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}