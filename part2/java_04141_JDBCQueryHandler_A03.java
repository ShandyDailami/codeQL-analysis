import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class java_04141_JDBCQueryHandler_A03 {
    private static final String URL = "jdbc:mysql://localhost:3306/dbname";
    private static final String USER = "username";
    private static final String PASS = "password";

    static Connection connection;

    public static void main(String[] args) {
        getConnection();
        runQuery("SELECT * FROM table_name WHERE condition");
        closeConnection();
    }

    public static void getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(URL, USER, PASS);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void runQuery(String query) {
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                // process the result set here
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void closeConnection() {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}