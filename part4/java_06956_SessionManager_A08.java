import java.sql.*;

public class java_06956_SessionManager_A08 {
    private static final String url = "jdbc:mysql://localhost:3306/testdb";
    private static final String username = "root";
    private static final String password = "password";

    private static SessionManager instance;
    private Connection connection;

    private java_06956_SessionManager_A08() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
       
            // In a real application, you should handle this exception appropriately
            // For example, by logging the exception or re-throwing it
        }
    }

    public static SessionManager getInstance() {
        if (instance == null) {
            instance = new SessionManager();
        }
        return instance;
    }

    public ResultSet executeQuery(String query) {
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            return resultSet;
        } catch (SQLException e) {
            e.printStackTrace();
            // In a real application, you should handle this exception appropriately
            // For example, by logging the exception or re-throwing it
       
            return null;
        }
    }

    public void executeUpdate(String query) {
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
            // In a real application, you should handle this exception appropriately
            // For example, by logging the exception or re-throwing it
        }
    }

    public void closeConnection() {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
            // In a real application, you should handle this exception appropriately
            // For example, by logging the exception or re-throwing it
        }
    }
}