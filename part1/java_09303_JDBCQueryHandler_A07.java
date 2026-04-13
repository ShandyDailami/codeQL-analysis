import java.sql.*;

public class java_09303_JDBCQueryHandler_A07 {
    private static final String url = "jdbc:mysql://localhost:3306/mydb";
    private static final String username = "root";
    private static final String password = "password";

    public static void main(String[] args) {
        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            Statement statement = connection.createStatement();

            // Authenticate user
            String user = "user1";
            String password = "password1";
            authenticateUser(connection, statement, user, password);

            // Query data
            String query = "SELECT * FROM my_table";
            retrieveData(connection, statement, query);

            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void authenticateUser(Connection connection, Statement statement, String user, String password) {
        try {
            String query = "SELECT * FROM users WHERE username = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, user);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                String dbPassword = resultSet.getString("password");
                if (password.equals(dbPassword)) {
                    System.out.println("User authenticated successfully!");
                } else {
                    System.out.println("Incorrect password!");
                }
            } else {
                System.out.println("User not found!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void retrieveData(Connection connection, Statement statement, String query) {
        try {
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                System.out.println(resultSet.getString("column_name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}