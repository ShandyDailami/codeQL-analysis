import java.sql.*;

public class java_26304_JDBCQueryHandler_A03 {
    private static final String URL = "jdbc:mysql://localhost:3306/test";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        try {
            connect();
            insertData();
            selectData();
            updateData();
            deleteData();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void connect() throws SQLException {
        DriverManager.registerDriver(new com.mysql.jdbc.Driver());
        Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
        // Perform security-sensitive operations here
        // ...
        connection.close();
    }

    private static void insertData() throws SQLException {
        Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
        String sql = "INSERT INTO test (name, age) VALUES (?, ?)";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, "John Doe");
        statement.setInt(2, 30);
        statement.executeUpdate();
        statement.close();
        connection.close();
    }

    private static void selectData() throws SQLException {
        Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
        String sql = "SELECT * FROM test WHERE age = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, 30);
        ResultSet result = statement.executeQuery();
        while (result.next()) {
            String name = result.getString("name");
            int id = result.getInt("id");
            System.out.println("Name: " + name + ", ID: " + id);
        }
        result.close();
        statement.close();
        connection.close();
    }

    private static void updateData() throws SQLException {
        Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
        String sql = "UPDATE test SET name = ? WHERE id = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, "John Doe Updated");
        statement.setInt(2, 1);
        statement.executeUpdate();
        statement.close();
        connection.close();
    }

    private static void deleteData() throws SQLException {
        Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
        String sql = "DELETE FROM test WHERE id = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, 1);
        statement.executeUpdate();
        statement.close();
        connection.close();
    }
}