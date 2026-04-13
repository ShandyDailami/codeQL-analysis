import java.sql.*;
import java.util.Properties;

public class java_13583_JDBCQueryHandler_A07 {

    private Connection conn = null;
    private Statement stmt = null;
    private ResultSet rs = null;

    private static final String DATABASE_DRIVER = "com.mysql.jdbc.Driver";
    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/mydatabase";
    private static final String USER = "root";
    private static final String PASSWORD = "root";

    public java_13583_JDBCQueryHandler_A07() {
        try {
            loadDriver();
            establishConnection();
            createStatement();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    private void loadDriver() throws ClassNotFoundException, SQLException {
        Class.forName(DATABASE_DRIVER);
    }

    private void establishConnection() throws SQLException {
        Properties props = new Properties();
        props.setProperty("user", USER);
        props.setProperty("password", PASSWORD);
        conn = DriverManager.getConnection(DATABASE_URL, props);
    }

    private void createStatement() throws SQLException {
        stmt = conn.createStatement();
    }

    public void performQuery(String query) throws SQLException {
        rs = stmt.executeQuery(query);
        while (rs.next()) {
            String userName = rs.getString("userName");
            String password = rs.getString("password");
            System.out.println("User Name: " + userName + ", Password: " + password);
        }
    }

    public static void main(String[] args) {
        JDBCQueryHandler queryHandler = new JDBCQueryHandler();
        try {
            queryHandler.performQuery("SELECT userName, password FROM Users WHERE userName = 'john' AND password = 'doe'");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}