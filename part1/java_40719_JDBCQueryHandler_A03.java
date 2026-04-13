import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class java_40719_JDBCQueryHandler_A03 {
    // Database credentials
    private static final String DB_USERNAME = "username";
    private static final String DB_PASSWORD = "password";
    // Database URL
    private static final String DB_URL = "jdbc:mysql://localhost:3306/mydb";

    private Connection connection;

    public java_40719_JDBCQueryHandler_A03() {
        try {
            this.connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void executeQuery(String query) {
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                System.out.println("ID: " + resultSet.getInt("id"));
                System.out.println("Name: " + resultSet.getString("name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        VanillaJDBCQueryHandler handler = new VanillaJDBCQueryHandler();
        handler.executeQuery("SELECT * FROM users");
    }
}