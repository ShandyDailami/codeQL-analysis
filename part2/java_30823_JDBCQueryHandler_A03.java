import java.sql.*;

public class java_30823_JDBCQueryHandler_A03 {
    private Connection connection;

    public java_30823_JDBCQueryHandler_A03(String url, String username, String password) throws SQLException {
        this.connection = DriverManager.getConnection(url, username, password);
    }

    public void executeQuery(String query) throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query);

        while (resultSet.next()) {
            System.out.println(resultSet.getString("name"));
        }
    }

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/testdb";
        String username = "root";
        String password = "password";

        try {
            JDBCQueryHandler handler = new JDBCQueryHandler(url, username, password);
            handler.executeQuery("SELECT * FROM employees");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}