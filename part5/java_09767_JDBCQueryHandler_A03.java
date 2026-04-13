import java.sql.*;

public class java_09767_JDBCQueryHandler_A03 {
    private Connection connection;

    public java_09767_JDBCQueryHandler_A03(String dbURL, String user, String password) {
        try {
            this.connection = DriverManager.getConnection(dbURL, user, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void executeQuery(String query) {
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                System.out.println(resultSet.getString("name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        JDBCQueryHandler handler = new JDBCQueryHandler("jdbc:mysql://localhost:3306/mydb", "username", "password");
        handler.executeQuery("SELECT * FROM users");
    }
}