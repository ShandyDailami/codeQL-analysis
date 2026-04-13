import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class java_09777_JDBCQueryHandler_A07 {
    private Connection connection;

    public java_09777_JDBCQueryHandler_A07() {
        try {
            this.connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/databaseName", "user", "password");
        } catch (SQLException e) {
            System.out.println("Failed to connect to the database: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void executeQuery(String query) {
        try {
            Statement statement = connection.createStatement();
            statement.execute(query);
        } catch (SQLException e) {
            System.out.println("Failed to execute query: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        JDBCQueryHandler handler = new JDBCQueryHandler();
        handler.executeQuery("SELECT * FROM tableName");
    }
}