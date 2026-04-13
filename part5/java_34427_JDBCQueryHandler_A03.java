import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class java_34427_JDBCQueryHandler_A03 {
    private String url;
    private String username;
    private String password;

    public java_34427_JDBCQueryHandler_A03(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    public void executeQuery(String query) {
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.execute();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        JDBCQueryHandler handler = new JDBCQueryHandler("jdbc:mysql://localhost:3306/db", "username", "password");
        handler.executeQuery("SELECT * FROM Users");
    }
}