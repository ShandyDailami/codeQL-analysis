import java.sql.*;

public class java_13152_JDBCQueryHandler_A07 {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/mydb";
    private static final String USER = "root";
    private static final String PASS = "password";

    private Connection connection;

    public java_13152_JDBCQueryHandler_A07() {
        try {
            this.connection = DriverManager.getConnection(DB_URL, USER, PASS);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ResultSet executeQuery(String query) {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return resultSet;
    }

    public void executeUpdate(String query) {
        PreparedStatement preparedStatement = null;

        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        JDBCQueryHandler queryHandler = new JDBCQueryHandler();

        String selectQuery = "SELECT * FROM Users";
        ResultSet resultSet = queryHandler.executeQuery(selectQuery);

        while (resultSet.next()) {
            String username = resultSet.getString("username");
            String password = resultSet.getString("password");

            System.out.println("Username: " + username);
            System.out.println("Password: " + password);
        }

        queryHandler.executeUpdate("UPDATE Users SET password = 'newpassword' WHERE username = 'test'");
    }
}