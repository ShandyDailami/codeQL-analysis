import java.sql.*;

public class java_40076_JDBCQueryHandler_A01 {
    private Connection connection;

    public java_40076_JDBCQueryHandler_A01() {
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost/test", "username", "password");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void performQuery(String query) {
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                System.out.println(resultSet.getString("columnName"));
            }

            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        JDBCQueryHandler handler = new JDBCQueryHandler();
        handler.performQuery("SELECT * FROM tableName");
    }
}