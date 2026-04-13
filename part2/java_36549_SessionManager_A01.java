public class java_36549_SessionManager_A01 {
    // Singleton instance
    private static SessionManager instance;

    // JDBC driver name and database URL
    private static final String DB_DRIVER = "com.mysql.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost:3306/mydb";

    // Database credentials
    private static final String USER = "user";
    private static final String PASS = "password";

    // An instance of the connection
    private Connection conn;

    // Constructor
    private java_36549_SessionManager_A01() {
        initializeConnection();
    }

    // Singleton instance getter
    public static SessionManager getInstance() {
        if (instance == null) {
            instance = new SessionManager();
        }
        return instance;
    }

    // Open a connection to the database
    private void initializeConnection() {
        try {
            Class.forName(DB_DRIVER);
            this.conn = DriverManager.getConnection(DB_URL, USER, PASS);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    // Return the connection
    public Connection getConnection() {
        return this.conn;
    }
}