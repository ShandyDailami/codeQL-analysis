import java.sql.*;

public class java_32436_JDBCQueryHandler_A08 {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/db_name";
    private static final String USER = "user";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        try {
            connectToDatabase();
        } catch (SQLException e) {
            System.out.println("Failed to connect to database: " + e.getMessage());
        }
    }

    private static void connectToDatabase() throws SQLException {
        Connection connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM table_name");

        while (resultSet.next()) {
            String column1 = resultSet.getString("column1");
            String column2 = resultSet.getString("column2");
            // Process data...
        }

        resultSet.close();
        statement.close();
        connection.close();
    }
}