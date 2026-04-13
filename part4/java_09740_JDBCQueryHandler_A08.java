import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class java_09740_JDBCQueryHandler_A08 {

    private Connection connection;
    private Statement statement;

    // Method to connect to database
    public void connectToDB(String dbUrl, String user, String password) {
        try {
            // Load the MySQL JDBC driver
            Class.forName("com.mysql.jdbc.Driver");

            // Establish a connection
            connection = DriverManager.getConnection(dbUrl, user, password);

            // Create a statement
            statement = connection.createStatement();

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    // Method to execute a SQL query
    public void executeQuery(String query) {
        try {
            // Execute the statement
            statement.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        JDBCQueryHandler handler = new JDBCQueryHandler();
        handler.connectToDB("jdbc:mysql://localhost:3306/mydb", "myuser", "mypassword");
        handler.executeQuery("INSERT INTO my_table (column1, column2) VALUES (value1, value2)");
    }
}