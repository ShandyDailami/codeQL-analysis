import java.sql.*;
import java.util.Properties;

public class java_01495_JDBCQueryHandler_A07 {
    // private instance variables
    private Connection conn;
    private Statement stmt;

    // constructor
    public java_01495_JDBCQueryHandler_A07(String dbUrl, String user, String password) throws SQLException {
        Properties props = new Properties();
        props.setProperty("user", user);
        props.setProperty("password", password);
        props.setProperty("characterEncoding", "utf-8");

        conn = DriverManager.getConnection(dbUrl, props);
        stmt = conn.createStatement();
    }

    // method to execute a select query
    public ResultSet executeSelectQuery(String query) throws SQLException {
        return stmt.executeQuery(query);
    }

    // method to execute an insert, update or delete query
    public int executeUpdateQuery(String query) throws SQLException {
        return stmt.executeUpdate(query);
    }

    // method to close the database connection
    public void closeConnection() throws SQLException {
        stmt.close();
        conn.close();
    }

    // main method to test the JDBCQueryHandler
    public static void main(String[] args) {
        try {
            JDBCQueryHandler jdbcHandler = new JDBCQueryHandler("jdbc:mysql://localhost:3306/mydatabase", "username", "password");
            ResultSet rs = jdbcHandler.executeSelectQuery("SELECT * FROM mytable");

            while (rs.next()) {
                System.out.println(rs.getString("columnName"));
            }

            jdbcHandler.closeConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}