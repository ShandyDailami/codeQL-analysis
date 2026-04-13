import java.sql.*;

public class java_20590_JDBCQueryHandler_A08 {

    public static final String URL = "jdbc:mysql://localhost:3306/mydatabase";
    public static final String USER = "username";
    public static final String PASSWORD = "password";

    public static void main(String[] args) {
        try {
            Connection connection = getConnection();
            if (connection != null) {
                handleQuery(connection);
                connection.close();
            }
        } catch (SQLException e) {
            System.out.println("Error while connecting to database: " + e.getMessage());
        }
    }

    private static Connection getConnection() throws SQLException {
        DriverManager.registerDriver(new com.mysql.jdbc.Driver());
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    private static void handleQuery(Connection connection) throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM mytable WHERE mycolumn = 'myvalue'");
        while (resultSet.next()) {
            // Do something with the result set
        }
    }
}