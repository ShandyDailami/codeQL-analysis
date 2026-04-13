import java.sql.*;

public class java_05402_JDBCQueryHandler_A01 {
    private static final String URL = "jdbc:mysql://localhost:3306/mydb";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    private Connection connection;

    public java_05402_JDBCQueryHandler_A01() {
        try {
            this.connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ResultSet executeQuery(String query) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(query);
            return statement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void executeUpdate(String query) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(query);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        JDBCQueryHandler queryHandler = new JDBCQueryHandler();

        String selectQuery = "SELECT * FROM Users";
        ResultSet resultSet = queryHandler.executeQuery(selectQuery);

        while (resultSet.next()) {
            String name = resultSet.getString("name");
            String email = resultSet.getString("email");
            System.out.println("Name: " + name);
            System.out.println("Email: " + email);
        }

        String insertQuery = "INSERT INTO Users (name, email) VALUES (?, ?)";
        queryHandler.executeUpdate(insertQuery);
    }
}