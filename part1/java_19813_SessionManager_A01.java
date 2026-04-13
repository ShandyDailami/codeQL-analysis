public class java_19813_SessionManager_A01 {
    private static SessionManager instance; // Create a static instance of the SessionManager
    private static Connection connection; // Database connection

    private java_19813_SessionManager_A01() {
        // Private constructor to prevent instantiation of the SessionManager
    }

    public static SessionManager getInstance() {
        if (instance == null) {
            instance = new SessionManager();
            connection = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
        }
        return instance;
    }

    public void execute(String query) {
        Statement statement = null;
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            // Process the result set
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Close the statement and the connection
            try {
                if (statement != null) statement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}