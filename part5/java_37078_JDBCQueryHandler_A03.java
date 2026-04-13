import java.sql.*;

public class java_37078_JDBCQueryHandler_A03 {

    private static final String URL = "jdbc:mysql://localhost:3306/mydatabase";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        JDBCQueryHandler queryHandler = new JDBCQueryHandler();
        try {
            queryHandler.connect();
            queryHandler.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            queryHandler.disconnect();
        }
    }

    private Connection connection;

    public void connect() throws SQLException {
        System.out.println("Connecting to database...");
        connection = DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public void executeQuery() throws SQLException {
        System.out.println("Executing query...");
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM my_table");
        while (resultSet.next()) {
            System.out.println("Row: " + resultSet.getString("name"));
        }
        resultSet.close();
        statement.close();
    }

    public void disconnect() {
        System.out.println("Disconnecting from database...");
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}