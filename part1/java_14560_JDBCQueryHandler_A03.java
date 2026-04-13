import java.sql.*;

public class java_14560_JDBCQueryHandler_A03 {

    private Connection connection;

    public java_14560_JDBCQueryHandler_A03(String dbUrl, String userName, String password) {
        try {
            connection = DriverManager.getConnection(dbUrl, userName, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void executeQuery(String query) {
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
        JDBCQueryHandler handler = new JDBCQueryHandler("jdbc:mysql://localhost/db", "username", "password");
        handler.executeQuery("SELECT * FROM tableName");
    }
}