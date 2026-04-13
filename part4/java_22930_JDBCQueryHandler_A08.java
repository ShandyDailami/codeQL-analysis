import java.sql.*;

public class java_22930_JDBCQueryHandler_A08 {

    private static final String url = "jdbc:mysql://localhost:3306/mydb";
    private static final String user = "username";
    private static final String password = "password";

    public static void main(String[] args) {
        QueryHandler(url, user, password);
    }

    public static void QueryHandler(String url, String user, String password) {
        try {
            Connection connection = DriverManager.getConnection(url, user, password);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM myTable");

            while (resultSet.next()) {
                System.out.println(resultSet.getString("columnName"));
            }

            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}