import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class java_07087_JDBCQueryHandler_A01 {

    // JDBC driver name and database URL
    private static final String DB_DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost:3306/mydatabase";

    // Database credentials
    private static final String USER = "myuser";
    private static final String PASS = "mypassword";

    public Connection getConnection() throws SQLException, ClassNotFoundException {
        Class.forName(DB_DRIVER);
        return DriverManager.getConnection(DB_URL, USER, PASS);
    }

    public void closeConnection(Connection connection) throws SQLException {
        if (connection != null) {
            connection.close();
        }
    }

    // Example of a query that does not involve any security-related operations
    public void performQuery() throws ClassNotFoundException, SQLException {
        Connection connection = null;
        try {
            connection = getConnection();
            // Assuming we're just selecting from a table
            String query = "SELECT * FROM mytable";
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                System.out.println(rs.getString("mycolumn"));
            }
        } finally {
            closeConnection(connection);
        }
    }
}