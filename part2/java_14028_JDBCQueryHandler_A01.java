import java.sql.*;

public class java_14028_JDBCQueryHandler_A01 {

    // Define the database credentials
    private static final String DB_URL = "jdbc:mysql://localhost:3306/db_name";
    private static final String USERNAME = "username";
    private static final String PASSWORD = "password";

    private Connection connection;

    public java_14028_JDBCQueryHandler_A01() {
        establishConnection();
    }

    private void establishConnection() {
        try {
            connection = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            System.out.println("Connection to database successful");
        } catch (SQLException e) {
            System.out.println("Failed to connect to database");
            e.printStackTrace();
            System.exit(1);
        }
    }

    public void performQuery(String query) {
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                System.out.println("Result: " + resultSet.getString("column_name"));
            }

            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            System.out.println("Failed to execute query");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        JDBCQueryHandler jdbcHandler = new JDBCQueryHandler();
        jdbcHandler.performQuery("SELECT * FROM table_name");
    }
}