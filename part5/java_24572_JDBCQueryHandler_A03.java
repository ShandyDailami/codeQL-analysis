import java.sql.*;
import java.util.Properties;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class java_24572_JDBCQueryHandler_A03 {
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/mydatabase";
    private static final String USER = "myuser";
    private static final String PASS = "mypassword";

    private BlockingQueue<String> queue = new ArrayBlockingQueue<>(10);

    public static void main(String[] args) {
        JDBCQueryHandler jdbcQueryHandler = new JDBCQueryHandler();
        jdbcQueryHandler.executeQuery("SELECT password FROM Users WHERE username = ?", "user1");
    }

    public void executeQuery(String query, String user) {
        Thread thread = new Thread(() -> {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Properties props = new Properties();
                props.setProperty("user", USER);
                props.setProperty("password", PASS);
                Connection connection = DriverManager.getConnection(JDBC_URL, props);
                PreparedStatement preparedStatement = connection.prepareStatement(query);
                preparedStatement.setString(1, user);
                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    System.out.println(resultSet.getString("password"));
                }
                connection.close();
            } catch (ClassNotFoundException | SQLException e) {
                e.printStackTrace();
            }
        });
        thread.start();
    }
}