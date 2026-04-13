import java.sql.*;

public class java_29058_JDBCQueryHandler_A01 {
    private String url;
    private String username;
    private String password;

    public java_29058_JDBCQueryHandler_A01(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    public boolean authenticate(String username, String password) {
        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            return connection.isValid(1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static void main(String[] args) {
        JDBCQueryHandler handler = new JDBCQueryHandler("jdbc:mysql://localhost:3306/mydb", "username", "password");
        System.out.println(handler.authenticate("username", "password"));
    }
}