import java.sql.*;

public class java_25953_JDBCQueryHandler_A08 {
    private static final String URL = "jdbc:mysql://localhost:3306/testdb";
    private static final String USER = "root";
    private static final String PASS = "password";

    private static Connection connection = null;

    public static void main(String[] args) {
        try {
            connect();
            if (connection != null) {
                executeQuery();
            } else {
                System.out.println("Failed to connect to database");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static void connect() throws SQLException {
        connection = DriverManager.getConnection(URL, USER, PASS);
        System.out.println("Connected to the database");
    }

    private static void executeQuery() throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM employees");

        while (resultSet.next()) {
            System.out.println(resultSet.getString("name") + " - " + resultSet.getString("email"));
        }

        statement.close();
        resultSet.close();
    }
}