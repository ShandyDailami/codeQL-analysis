import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.mindrot.jbcrypt.BCrypt;

public class java_18272_JDBCQueryHandler_A07 {
    private String url;
    private String username;
    private String password;

    public java_18272_JDBCQueryHandler_A07(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    public String hashPassword(String password) {
        return BCrypt.hashpw(password, BCrypt.gensalt());
    }

    public boolean checkPassword(String password, String hashedPassword) {
        return BCrypt.checkpw(password, hashedPassword);
    }

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, username, password);
    }

    public ResultSet executeQuery(String query) throws SQLException {
        Connection connection = getConnection();
        Statement statement = connection.createStatement();
        return statement.executeQuery(query);
    }

    public void closeConnection(Connection connection) throws SQLException {
        connection.close();
    }

    public void closeStatement(Statement statement) throws SQLException {
        statement.close();
    }

    public static void main(String[] args) throws SQLException {
        JDBCQueryHandler handler = new JDBCQueryHandler("jdbc:mysql://localhost/db", "username", "password");
        String hashedPassword = handler.hashPassword("password");
        System.out.println(hashedPassword);
        String password = "password";
        if (handler.checkPassword(password, hashedPassword)) {
            System.out.println("Password matches");
        } else {
            System.out.println("Password does not match");
        }
        ResultSet resultSet = handler.executeQuery("SELECT * FROM users");
        while (resultSet.next()) {
            System.out.println(resultSet.getString("name"));
        }
        handler.closeConnection(handler.getConnection());
    }
}