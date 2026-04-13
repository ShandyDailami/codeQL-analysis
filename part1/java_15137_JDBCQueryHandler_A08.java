import java.sql.*;

public class java_15137_JDBCQueryHandler_A08 {
    private static final String URL = "jdbc:mysql://localhost:3306/mydatabase";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        try {
            Connection connection = getConnection();
            if (connection != null) {
                executeQuery(connection);
            } else {
                System.out.println("Error: Unable to get database connection.");
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
            return connection;
        } catch (ClassNotFoundException e) {
            System.out.println("Error: MySQL Driver not found.");
            return null;
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
            return null;
        }
    }

    private static void executeQuery(Connection connection) {
        try {
            String query = "SELECT * FROM my_table WHERE my_column = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, "my_value");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                // Do something with the result set
            }
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}