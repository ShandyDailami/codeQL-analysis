import java.sql.*;

public class java_09007_JDBCQueryHandler_A03 {
    private static final String URL = "your_db_url";
    private static final String USER = "your_username";
    private static final String PASS = "your_password";

    private Connection connection;

    public java_09007_JDBCQueryHandler_A03() {
        try {
            connection = DriverManager.getConnection(URL, USER, PASS);
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle exception properly
            System.exit(1);
        }
    }

    public void performQuery(String query) {
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                // Process resultSet data here
            }

            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle exception properly
        }
    }

    public static void main(String[] args) {
        VanillaJDBCQueryHandler handler = new VanillaJDBCQueryHandler();
        handler.performQuery("SELECT * FROM your_table");
    }
}