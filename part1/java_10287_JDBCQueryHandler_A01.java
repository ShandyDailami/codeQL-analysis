import java.sql.*;

public class java_10287_JDBCQueryHandler_A01 {
    private static String url;
    private static String username;
    private static String password;

    static {
        url = "jdbc:mysql://localhost:3306/mydatabase";
        username = "username";
        password = "password";
    }

    public static void main(String[] args) {
        try {
            Connection connection = getConnection();
            if (connection != null) {
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM my_table");
                while (resultSet.next()) {
                    System.out.println(resultSet.getString("my_column"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}