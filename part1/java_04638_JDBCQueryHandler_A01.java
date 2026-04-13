import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class java_04638_JDBCQueryHandler_A01 {
    private Connection connection;
    private Statement statement;

    public java_04638_JDBCQueryHandler_A01(String dbURL, String user, String password) throws SQLException {
        this.connection = DriverManager.getConnection(dbURL, user, password);
        this.statement = connection.createStatement();
    }

    public ResultSet executeQuery(String query) throws SQLException {
        return this.statement.executeQuery(query);
    }

    public void closeConnection() throws SQLException {
        this.statement.close();
        this.connection.close();
    }

    public static void main(String[] args) {
        try {
            JDBCQueryHandler handler = new JDBCQueryHandler("jdbc:mysql://localhost:3306/test", "root", "root");
            ResultSet rs = handler.executeQuery("SELECT * FROM Users");
            while (rs.next()) {
                System.out.println("User ID: " + rs.getString("UserID"));
                System.out.println("Name: " + rs.getString("UserName"));
            }
            handler.closeConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}