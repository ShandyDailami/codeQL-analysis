public class java_16618_SessionManager_A07 {
    private static SessionManager instance = null;
    private static Connection conn = null;

    private java_16618_SessionManager_A07() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/mydb", "username", "password");
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

    public boolean validateUser(String username, String password) {
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Users WHERE Username ='" + username + "' and Password ='" + password + "'");
            return rs.next();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}