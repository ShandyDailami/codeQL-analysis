import java.sql.*;

public class java_07211_SessionManager_A03 {
    private static SessionManager instance;

    private java_07211_SessionManager_A03() {
        // Private constructor to prevent instantiation of this class
    }

    public static SessionManager getInstance() {
        if (instance == null) {
            instance = new SessionManager();
        }
        return instance;
    }

    private Connection connection;

    public void connect(String dbUrl, String dbUser, String dbPassword) {
        try {
            connection = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void executeStatement(String sql) {
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                // Process the result set here
            }

            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void executeUpdate(String sql) {
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate(sql);

            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}