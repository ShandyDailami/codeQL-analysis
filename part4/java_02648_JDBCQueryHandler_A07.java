import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class java_02648_JDBCQueryHandler_A07 {
    private Connection connection;

    public java_02648_JDBCQueryHandler_A07(String dbURL, String userName, String password) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver"); // Load MySQL JDBC Driver
        this.connection = DriverManager.getConnection(dbURL, userName, password);
    }

    public boolean isValidUser(String username, String password) {
        String query = "SELECT * FROM Users WHERE username = ? AND password = ?";

        try (PreparedStatement statement = this.connection.prepareStatement(query)) {
            statement.setString(1, username);
            statement.setString(2, password);

            ResultSet result = statement.executeQuery();

            if (result.next()) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        JDBCQueryHandler handler = new JDBCQueryHandler("jdbc:mysql://localhost:3306/testdb", "username", "password");

        if (handler.isValidUser("validUsername", "validPassword")) {
            System.out.println("User valid!");
        } else {
            System.out.println("User invalid!");
        }
    }
}