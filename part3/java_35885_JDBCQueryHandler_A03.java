import java.sql.*;
import java.util.Properties;

public class java_35885_JDBCQueryHandler_A03 {
    private Connection conn;

    public java_35885_JDBCQueryHandler_A03(String dbURL, Properties props) throws SQLException {
        this.conn = DriverManager.getConnection(dbURL, props);
    }

    public ResultSet executeQuery(String query) throws SQLException {
        Statement stmt = conn.createStatement();
        return stmt.executeQuery(query);
    }

    public void closeConnection() throws SQLException {
        conn.close();
    }

    public static void main(String[] args) {
        String dbURL = "jdbc:mysql://localhost:3306/mydb";
        Properties props = new Properties();
        props.setProperty("user", "root");
        props.setProperty("password", "password");
        props.setProperty("useSSL", "false");
        props.setProperty("verifyServerCertificate", "false");
        props.setProperty("requireSSL", "false");

        try {
            JDBCQueryHandler handler = new JDBCQueryHandler(dbURL, props);
            ResultSet result = handler.executeQuery("SELECT * FROM my_table");

            while (result.next()) {
                System.out.println(result.getString("name"));
            }

            handler.closeConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}