import java.sql.*;

public class java_30714_JDBCQueryHandler_A01 {

    private static final String URL = "jdbc:your_database_url";
    private static final String USER = "username";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        try {
            connectDatabase();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void connectDatabase() throws SQLException {
        DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());

        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            String selectQuery = "SELECT * FROM table_name"; // replace with your query
            try (Statement statement = connection.createStatement()) {
                ResultSet resultSet = statement.executeQuery(selectQuery);

                while (resultSet.next()) {
                    System.out.println("Record " + resultSet.getString("field_name")); // replace with your field
                }
            }
        }
    }
}