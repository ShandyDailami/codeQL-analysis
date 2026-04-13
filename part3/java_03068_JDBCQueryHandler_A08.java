import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class java_03068_JDBCQueryHandler_A08 {

    private Connection connection;

    public java_03068_JDBCQueryHandler_A08(String dbUrl, String user, String password) throws SQLException {
        this.connection = DriverManager.getConnection(dbUrl, user, password);
    }

    public void executeQuery(String query) throws SQLException {
        Statement statement = connection.createStatement();
        statement.executeUpdate(query);
        statement.close();
    }

    public void closeConnection() throws SQLException {
        connection.close();
    }

    public static void main(String[] args) {
        try {
            new JDBCQueryHandler("jdbc:mysql://localhost:3306/test", "root", "root").executeQuery("SELECT * FROM Employees");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}