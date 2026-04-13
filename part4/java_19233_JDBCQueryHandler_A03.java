import java.sql.*;

public class java_19233_JDBCQueryHandler_A03 {
    private static final String url = "jdbc:mysql://localhost:3306/testdb";
    private static final String username = "root";
    private static final String password = "password";
    private static Connection connection = null;
    private static Statement statement = null;

    static {
        try {
            connection = DriverManager.getConnection(url, username, password);
            statement = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        String query = "SELECT * FROM Users WHERE username = '" + args[0] + "' AND password = '" + args[1] + "'";
        ResultSet resultSet = null;
        try {
            resultSet = statement.executeQuery(query);
            if (resultSet.next()) {
                System.out.println("User found!");
            } else {
                System.out.println("User not found!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}