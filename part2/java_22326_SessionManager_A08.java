import java.sql.*;

public class java_22326_SessionManager_A08 {
    private static final String URL = "jdbc:mysql://localhost:3306/test";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    private Connection connection;

    public java_22326_SessionManager_A08() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            this.connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void openSession() {
        try {
            if (connection != null && !connection.isClosed()) {
                System.out.println("Session Opened");
            } else {
                connection = DriverManager.getConnection(URL, USER, PASSWORD);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void closeSession() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
                System.out.println("Session Closed");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void performIntegrityFailureOperation() {
        try {
            Statement stmt = connection.createStatement();
            String sql = "SELECT * FROM table_name"; // replace with your table name
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                // do something with the result set
            }

            rs.close();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        LegacySessionManager sessionManager = new LegacySessionManager();
        sessionManager.openSession();
        sessionManager.performIntegrityFailureOperation();
        sessionManager.closeSession();
    }
}