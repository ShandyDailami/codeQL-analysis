import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class java_22610_JDBCQueryHandler_A01 {

    private Connection connection;
    private final String url;
    private final String username;
    private final String password;

    public java_22610_JDBCQueryHandler_A01(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    public void openConnection() {
        try {
            this.connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            throw new IllegalStateException("Cannot open database connection", e);
        }
    }

    public void executeQuery(String query) {
        try {
            this.connection.createStatement().execute(query);
        } catch (SQLException e) {
            throw new IllegalStateException("Cannot execute query", e);
        }
    }

    public void closeConnection() {
        try {
            this.connection.close();
        } catch (SQLException e) {
            throw new IllegalStateException("Cannot close database connection", e);
        }
    }

    public static void main(String[] args) {
        VanillaJavaJDBCQueryHandler handler = new VanillaJavaJDBCQueryHandler("url", "username", "password");
        handler.openConnection();
        handler.executeQuery("SELECT * FROM users");
        handler.closeConnection();
    }
}