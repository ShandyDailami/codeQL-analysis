import java.sql.*;

public class java_10985_JDBCQueryHandler_A01 {
    private static final String URL = "jdbc:your_database_url";
    private static final String USER = "username";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        try {
            connectToDatabase();
        } catch (SQLException e) {
            System.out.println("Error connecting to database: " + e.getMessage());
        }
    }

    private static void connectToDatabase() throws SQLException {
        DriverManager.registerDriver(new com.mysql.jdbc.Driver());
        Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);

        String query = "SELECT * FROM your_table_name WHERE your_column_name = ?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, "your_value");
        ResultSet resultSet = statement.executeQuery();

        while (resultSet.next()) {
            System.out.println("Found user with value: " + resultSet.getString("your_column_name"));
        }

        connection.close();
    }
}