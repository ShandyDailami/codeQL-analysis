import java.sql.*;

public class java_37545_JDBCQueryHandler_A03 {

    private static final String DB_URL = "jdbc:mysql://localhost:3306/mydatabase";
    private static final String USER = "myuser";
    private static final String PASS = "mypassword";

    private static Connection connection;
    private static Statement statement;

    public static void main(String[] args) {
        connectToDB();
        executeQuery("SELECT * FROM my_table");
        closeDB();
    }

    private static void connectToDB() {
        try {
            connection = DriverManager.getConnection(DB_URL, USER, PASS);
            statement = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void executeQuery(String query) {
        try {
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                System.out.println("Data: " + resultSet.getString("column_name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void closeDB() {
        try {
            if (statement != null)
                statement.close();
            if (connection != null)
                connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}