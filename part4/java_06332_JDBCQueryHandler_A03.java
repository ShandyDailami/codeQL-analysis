import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class java_06332_JDBCQueryHandler_A03 {
    private Connection connection;
    private Statement statement;

    public java_06332_JDBCQueryHandler_A03(String dbURL, String user, String password) throws SQLException {
        connection = DriverManager.getConnection(dbURL, user, password);
        statement = connection.createStatement();
    }

    public ResultSet executeQuery(String query) throws SQLException {
        return statement.executeQuery(query);
    }

    public int executeUpdate(String query) throws SQLException {
        return statement.executeUpdate(query);
    }

    public void close() throws SQLException {
        statement.close();
        connection.close();
    }

    public static void main(String[] args) {
        try {
            JDBCQueryHandler handler = new JDBCQueryHandler("jdbc:mysql://localhost:3306/mydatabase", "myusername", "mypassword");
            ResultSet rs = handler.executeQuery("SELECT * FROM mytable");
            while (rs.next()) {
                System.out.println(rs.getString("mycolumn"));
            }
            handler.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}