import java.sql.*;

public class java_22092_JDBCQueryHandler_A07 {

    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/db";
    private static final String USER = "username";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        try {
            connectDB();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void connectDB() throws SQLException {
        Connection connection = DriverManager.getConnection(JDBC_URL, USER, PASSWORD);
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM table");

        while (resultSet.next()) {
            String column1 = resultSet.getString("column1");
            // More code here
        }

        statement.close();
        connection.close();
    }
}