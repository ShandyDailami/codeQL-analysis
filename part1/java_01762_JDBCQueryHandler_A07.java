import java.sql.*;
import java.util.Properties;

public class java_01762_JDBCQueryHandler_A07 {

    private Connection connection;

    public java_01762_JDBCQueryHandler_A07(String dbURL, String user, String password) {
        try {
            Properties props = new Properties();
            props.setProperty("user", user);
            props.setProperty("password", password);
            props.setProperty("useSSL", "false");
            props.setProperty("verifyServerCertificate", "false");
            props.setProperty("trustAllCertificates", "true");

            connection = DriverManager.getConnection(dbURL, props);
        } catch (SQLException e) {
            System.out.println("Error in database connection : " + e.getMessage());
            e.printStackTrace();
        }
    }

    public ResultSet executeQuery(String query) {
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            return rs;
        } catch (SQLException e) {
            System.out.println("Error in executing query : " + e.getMessage());
            e.printStackTrace();
        }
        return null;
    }

    public int executeUpdate(String query) {
        try {
            Statement stmt = connection.createStatement();
            int result = stmt.executeUpdate(query);
            return result;
        } catch (SQLException e) {
            System.out.println("Error in executing update query : " + e.getMessage());
            e.printStackTrace();
        }
        return -1;
    }

    public boolean closeConnection() {
        try {
            connection.close();
            return true;
        } catch (SQLException e) {
            System.out.println("Error in closing connection : " + e.getMessage());
            return false;
        }
    }
}