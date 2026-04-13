import java.sql.*;

public class java_00295_JDBCQueryHandler_A08 {
    private static final String url = "jdbc:mysql://localhost:3306/mydb";
    private static final String user = "root";
    private static final String password = "password";

    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;

        try {
            connection = DriverManager.getConnection(url, user, password);
            statement = connection.createStatement();

            // Query 1
            ResultSet resultSet = statement.executeQuery("SELECT * FROM Users WHERE id = " + 123);

            while (resultSet.next()) {
                System.out.println(resultSet.getString("username"));
            }

            // Query 2
            String insertQuery = "INSERT INTO Users (id, username) VALUES (" + 456 + ", 'testUser2')";
            statement.executeUpdate(insertQuery);

            // Query 3
            ResultSet resultSet2 = statement.executeQuery("SELECT * FROM Users WHERE id = " + 456);
            while (resultSet2.next()) {
                System.out.println(resultSet2.getString("username"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}