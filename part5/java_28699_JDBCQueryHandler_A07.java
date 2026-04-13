import java.sql.*;
import java.util.Properties;

public class java_28699_JDBCQueryHandler_A07 {

    private static final String DB_URL = "jdbc:mysql://localhost:3306/mydb";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    private Connection conn = null;
    private Statement stmt = null;

    // Method to connect to the database
    public void connectToDB() {
        try {
            Properties props = new Properties();
            props.setProperty("user", USER);
            props.setProperty("password", PASSWORD);
            props.setProperty("characterEncoding", "utf8");

            conn = DriverManager.getConnection(DB_URL, props);
            stmt = conn.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Method to execute a query
    public ResultSet executeQuery(String query) {
        try {
            return stmt.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // Method to disconnect from the database
    public void disconnect() {
        try {
            if (stmt != null) stmt.close();
            if (conn != null) conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        JDBCQueryHandler handler = new JDBCQueryHandler();
        handler.connectToDB();
        ResultSet result = handler.executeQuery("SELECT * FROM myTable");
        while (result.next()) {
            System.out.println(result.getString("columnName"));
        }
        handler.disconnect();
    }
}