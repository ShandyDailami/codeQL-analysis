import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class java_41943_SessionManager_A03 {

    private static SessionManager instance = null;

    private java_41943_SessionManager_A03() {
        // Empty constructor to restrict the creation of a new instance of this class
    }

    public static SessionManager getInstance() {
        if (instance == null) {
            instance = new SessionManager();
        }
        return instance;
    }

    private Connection connection = null;

    public Connection getConnection() {
        if (connection == null) {
            String url = "jdbc:mysql://localhost:3306/testdb"; // Change with your database information
            String username = "root"; // Change with your username
            String password = "password"; // Change with your password

            try {
                Class.forName("com.mysql.cj.jdbc.Driver"); // MySQL Connector/J
                connection = DriverManager.getConnection(url, username, password);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return connection;
    }

    public void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    // Example of a method that opens a new session and executes a SQL query
    public void executeQuery(String query) {
        try (Connection conn = getConnection()) {
            if (conn != null) {
                // Prepare and execute the query
                PreparedStatement pstmt = conn.prepareStatement(query);
                ResultSet rs = pstmt.executeQuery();

                // Process the results
                while (rs.next()) {
                    System.out.println(rs.getString("name"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
    }
}