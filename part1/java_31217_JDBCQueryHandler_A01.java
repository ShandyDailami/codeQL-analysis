import java.sql.*;

public class java_31217_JDBCQueryHandler_A01 {

    private static final String URL = "jdbc:mysql://localhost:3306/db_name";
    private static final String USER = "username";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        try {
            Connection connection = getConnection();
            if (connection != null) {
                String query = "SELECT * FROM table_name";
                ResultSet resultSet = connection.createStatement().executeQuery(query);
                while (resultSet.next()) {
                    String column1 = resultSet.getString("column1");
                    String column2 = resultSet.getString("column2");
                    // process data
                }
                resultSet.close();
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}