import java.sql.*;

public class java_05279_JDBCQueryHandler_A08 {

    private static final String url = "jdbc:mysql://localhost:3306/mydatabase";
    private static final String username = "root";
    private static final String password = "password";

    public static void main(String[] args) {
        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM myTable WHERE integrity = 'fail'");

            while (resultSet.next()) {
                System.out.println("Integrity failure in table myTable for id " + resultSet.getString("id"));
            }

            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}