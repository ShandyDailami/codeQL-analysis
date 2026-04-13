import java.sql.*;

public class java_19416_JDBCQueryHandler_A03 {
    private String url;
    private String username;
    private String password;

    public java_19416_JDBCQueryHandler_A03(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    public void connect() throws SQLException {
        Connection connection = DriverManager.getConnection(url, username, password);
        System.out.println("Connected to the database");
        connection.close();
    }

    public void executeQuery(String query) throws SQLException {
        Connection connection = DriverManager.getConnection(url, username, password);
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query);

        while (resultSet.next()) {
            System.out.println("Result: " + resultSet.getString("name"));
        }

        connection.close();
    }
}

// Usage
public class Main {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/db";
        String username = "user";
        String password = "password";

        JDBCQueryHandler handler = new JDBCQueryHandler(url, username, password);

        try {
            handler.connect();
            handler.executeQuery("SELECT * FROM users");
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}