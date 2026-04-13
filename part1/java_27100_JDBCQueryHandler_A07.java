import java.sql.*;
import java.util.Properties;

public class java_27100_JDBCQueryHandler_A07 {
    private Connection conn;
    private Statement stmt;

    public java_27100_JDBCQueryHandler_A07(String dbURL, String userName, String password) throws SQLException {
        Properties props = new Properties();
        props.setProperty("user", userName);
        props.setProperty("password", password);
        props.setProperty("ssl", "false");

        this.conn = DriverManager.getConnection(dbURL, props);
        this.stmt = conn.createStatement();
    }

    public ResultSet executeQuery(String query) throws SQLException {
        return stmt.executeQuery(query);
    }

    public int executeUpdate(String query) throws SQLException {
        return stmt.executeUpdate(query);
    }

    public void closeConnection() throws SQLException {
        this.stmt.close();
        this.conn.close();
    }
}

public class Main {
    public static void main(String[] args) {
        try {
            // Assuming the database is MySQL, replace with your actual DB URL, username, and password
            JDBCQueryHandler handler = new JDBCQueryHandler("jdbc:mysql://localhost:3306/mydb", "username", "password");

            ResultSet rs = handler.executeQuery("SELECT * FROM my_table");

            while (rs.next()) {
                System.out.println(rs.getString("column_name"));
            }

            handler.closeConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}