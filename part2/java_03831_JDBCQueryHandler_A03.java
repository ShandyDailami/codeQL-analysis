import java.sql.*;

public class java_03831_JDBCQueryHandler_A03 {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/mydb";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        try {
            executeQuery(USER, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void executeQuery(String user, String password) throws SQLException {
        Connection connection = null;
        Statement statement = null;

        try {
            connection = DriverManager.getConnection(DB_URL, user, password);
            statement = connection.createStatement();

            String query = "SELECT * FROM myTable WHERE myColumn = " + user;
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                String value = resultSet.getString("myColumn");
                System.out.println("Value: " + value);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
    }
}