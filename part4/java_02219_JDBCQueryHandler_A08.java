import java.sql.*;

public class java_02219_JDBCQueryHandler_A08 {
    private static final String URL = "jdbc:mysql://localhost:3306/your_database";
    private static final String USER = "your_username";
    private static final String PASSWORD = "your_password";

    public static void main(String[] args) {
        try {
            connectToDatabase();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void connectToDatabase() throws SQLException {
        Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
        Statement statement = connection.createStatement();

        String query = "SELECT * FROM your_table"; // Replace with your query
        ResultSet resultSet = statement.executeQuery(query);

        while (resultSet.next()) {
            // Process the result set here
        }

        resultSet.close();
        statement.close();
        connection.close();
    }
}