import java.sql.*;

public class java_19933_JDBCQueryHandler_A03 {

    private static final String URL = "jdbc:yourDatabaseURL";
    private static final String USER = "yourUsername";
    private static final String PASSWORD = "yourPassword";

    public static void main(String[] args) {
        executeQuery("SELECT * FROM yourTable");
    }

    private static void executeQuery(String query) {
        try {
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                // process the result set
                System.out.println(resultSet.getString("columnName"));
            }

            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}