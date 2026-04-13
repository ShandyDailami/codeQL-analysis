import java.sql.*;

public class java_33829_JDBCQueryHandler_A01 {
    private Connection connection;

    public java_33829_JDBCQueryHandler_A01(String url, String username, String password) throws SQLException {
        this.connection = DriverManager.getConnection(url, username, password);
    }

    public void executeUpdate(String sql) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.executeUpdate();
        statement.close();
    }

    public ResultSet executeQuery(String sql) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(sql);
        return statement.executeQuery();
    }

    public static void main(String[] args) {
        try {
            VanillaJDBCQueryHandler handler = new VanillaJDBCQueryHandler("jdbc:mysql://localhost:3306/test", "username", "password");

            // Insert a row into the database
            handler.executeUpdate("INSERT INTO test (id, name) VALUES (1, 'Test User')");

            // Retrieve rows from the database
            ResultSet resultSet = handler.executeQuery("SELECT * FROM test WHERE id = 1");
            while (resultSet.next()) {
                System.out.println("ID: " + resultSet.getInt("id"));
                System.out.println("Name: " + resultSet.getString("name"));
            }
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}