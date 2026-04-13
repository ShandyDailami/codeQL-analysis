public class java_36909_SessionManager_A01 {

    private static SessionManager instance;
    private Session currentSession;

    private java_36909_SessionManager_A01() {
        // Private constructor to prevent instantiation
    }

    public static SessionManager getInstance() {
        if (instance == null) {
            instance = new SessionManager();
        }
        return instance;
    }

    public void openSession() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // Load MySQL Driver
            String url = "jdbc:mysql://localhost:3306/testdb";
            String username = "root";
            String password = "password";
            currentSession = SessionFactory.openSession(url, username, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void closeSession() {
        if (currentSession != null) {
            currentSession.close();
        }
    }

    public void executeQuery(String query) {
        Statement stmt = null;
        try {
            stmt = currentSession.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                // Process the result set here
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close the statement and release any resources
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}