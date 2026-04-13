import java.sql.*;

public class java_17329_SessionManager_A08 {
    private static SessionManager instance = null;
    private Connection connection = null;

    private java_17329_SessionManager_A08() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // Load MySQL driver
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/mydb?useSSL=false&serverTimezone=UTC", "username", "password");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static SessionManager getInstance() {
        if (instance == null) {
            instance = new SessionManager();
        }
        return instance;
    }

    public ResultSet executeQuery(String query) {
        Statement stmt = null;
        try {
            stmt = connection.createStatement();
            return stmt.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public int executeUpdate(String query) {
        Statement stmt = null;
        try {
            stmt = connection.createStatement();
            return stmt.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }
    }

    public void closeConnection() {
        try {
            if (connection != null)
                connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}