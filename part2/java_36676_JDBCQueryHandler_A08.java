import java.sql.*;

public class java_36676_JDBCQueryHandler_A08 {
    private static final String URL = "jdbc:mysql://localhost:3306/mydatabase";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        try {
            Connection connection = getConnection();
            if (connection != null) {
                executeQuery(connection);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static Connection getConnection() throws SQLException {
        DriverManager.registerDriver(new com.mysql.jdbc.Driver());
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    private static void executeQuery(Connection connection) throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM users WHERE id = " + 123);
        while (resultSet.next()) {
            // Do something with the result set
            String name = resultSet.getString("name");
            // The following line will fail if the id is not found in the database
            // and an IntegrityFailure will be thrown
            Integer age = resultSet.getInt("age");
        }
        resultSet.close();
        statement.close();
        connection.close();
    }
}