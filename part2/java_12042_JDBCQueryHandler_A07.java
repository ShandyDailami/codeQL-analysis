import java.sql.*;
import java.util.Properties;

public class java_12042_JDBCQueryHandler_A07 {
    private static final String DB_DRIVER = "com.mysql.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost:3306/mydatabase";
    private static final String USERNAME = "myusername";
    private static final String PASSWORD = "mypassword";

    static Connection connection = null;

    public static void main(String[] args) {
        try {
            loadDriver();
            establishConnection();
            executeQuery();
            closeConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void loadDriver() {
        try {
            Class.forName(DB_DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static void establishConnection() {
        Properties props = new Properties();
        props.setProperty("user", USERNAME);
        props.setProperty("password", PASSWORD);

        try {
            connection = DriverManager.getConnection(DB_URL, props);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void executeQuery() {
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM Users WHERE AuthFailure > 5");

            while (resultSet.next()) {
                String username = resultSet.getString("username");
                int authFailure = resultSet.getInt("AuthFailure");

                System.out.println("Username: " + username + ", AuthFailure: " + authFailure);
            }

            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void closeConnection() {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}