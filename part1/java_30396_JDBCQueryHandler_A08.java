import java.sql.*;

public class java_30396_JDBCQueryHandler_A08 {
    private static final String url = "jdbc:mysql://localhost:3306/mydb";
    private static final String username = "root";
    private static final String password = "password";
    private static Connection connection;
    private static PreparedStatement statement;

    private java_30396_JDBCQueryHandler_A08() {
    }

    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public static void executeStatement(String query) {
        try {
            statement = getConnection().prepareStatement(query);
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static ResultSet executeQuery(String query) {
        try {
            statement = getConnection().prepareStatement(query);
            return statement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        // Security-sensitive operations
        // 1. Data insertion
        executeStatement("INSERT INTO users (username, password, email) VALUES (?, ?, ?)");

        // 2. Data retrieval
        ResultSet rs = executeQuery("SELECT * FROM users WHERE username = ?");
        while (rs.next()) {
            String username = rs.getString("username");
            String password = rs.getString("password");
            String email = rs.getString("email");
            // Do something with the retrieved data
        }

        // 3. Data modification
        executeStatement("UPDATE users SET email = ? WHERE username = ?");

        // 4. Data deletion
        executeStatement("DELETE FROM users WHERE username = ?");
    }
}