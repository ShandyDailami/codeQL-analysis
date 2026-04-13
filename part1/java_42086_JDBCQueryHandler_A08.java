import java.sql.*;

public class java_42086_JDBCQueryHandler_A08 {

    private static final String URL = "jdbc:mysql://localhost:3306/db_name";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        try {
            Connection connection = getConnection();
            String query = "SELECT * FROM table_name WHERE column_name = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, "value");
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                // Process the result set here
            }

            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}