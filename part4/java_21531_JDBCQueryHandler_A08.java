import java.sql.*;

public class java_21531_JDBCQueryHandler_A08 {
    private static final String URL = "jdbc:mysql://localhost:3306/mydatabase";
    private static final String USER = "username";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        try {
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
            Statement statement = connection.createStatement();

            // Assume that we want to insert a row into a table
            String sql = "INSERT INTO my_table (column1, column2) VALUES ('value1', 'value2')";
            statement.executeUpdate(sql);

            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}