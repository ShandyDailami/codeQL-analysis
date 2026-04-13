import java.sql.*;

public class java_08774_JDBCQueryHandler_A01 {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/mydatabase";
    private static final String USER = "username";
    private static final String PASSWORD = "password";

    private Connection connection;
    private Statement statement;

    public java_08774_JDBCQueryHandler_A01() {
        connectToDB();
    }

    private void connectToDB() {
        try {
            connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            statement = connection.createStatement();
        } catch (SQLException e) {
            System.out.println("Unable to connect to database: " + e.getMessage());
        }
    }

    public void executeQuery(String query) {
        if (connection != null) {
            try {
                ResultSet resultSet = statement.executeQuery(query);
                handleResultSet(resultSet);
            } catch (SQLException e) {
                System.out.println("Error executing query: " + e.getMessage());
            }
        } else {
            System.out.println("Error: Cannot execute query because no connection is available.");
        }
    }

    private void handleResultSet(ResultSet resultSet) {
        try {
            while (resultSet.next()) {
                System.out.println("ResultSet: " + resultSet.getString("column_name"));
            }
        } catch (SQLException e) {
            System.out.println("Error handling result set: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        new JDBCQueryHandler().executeQuery("SELECT * FROM my_table");
    }
}