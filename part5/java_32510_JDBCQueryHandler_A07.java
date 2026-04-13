import java.sql.*;
import java.util.Properties;

public class java_32510_JDBCQueryHandler_A07 {

    private Connection conn;
    private Statement stmt;
    private Properties props;

    public java_32510_JDBCQueryHandler_A07(String url, String username, String password, String driver) {
        props = new Properties();
        props.setProperty("user", username);
        props.setProperty("password", password);
        props.setProperty("driver", driver);

        try {
            conn = DriverManager.getConnection(url, props);
            stmt = conn.createStatement();
        } catch (SQLException e) {
            System.out.println("Error in connecting to the database");
            e.printStackTrace();
        }
    }

    public void executeQuery(String query) {
        try {
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                // TODO: Process the result set
            }
        } catch (SQLException e) {
            System.out.println("Error in executing the query");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        // TODO: Implement the main method
    }

}