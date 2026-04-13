import java.sql.*;

public class java_13774_JDBCQueryHandler_A03 {
    private static final String url = "jdbc:mysql://localhost:3306/mydb";
    private static final String user = "root";
    private static final String password = "password";

    private Connection connection;

    public java_13774_JDBCQueryHandler_A03() {
        try {
            connection = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ResultSet executeQuery(String query) {
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            return resultSet;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void executeUpdate(String query) {
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        JDBCQueryHandler handler = new JDBCQueryHandler();
        ResultSet resultSet = handler.executeQuery("SELECT * FROM my_table");

        try {
            while (resultSet.next()) {
                System.out.println(resultSet.getString("my_column"));
            }
            handler.executeUpdate("UPDATE my_table SET my_column = 'new_value' WHERE my_column = 'old_value'");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}