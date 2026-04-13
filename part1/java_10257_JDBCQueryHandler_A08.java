import java.sql.*;

public class java_10257_JDBCQueryHandler_A08 {

    // Assuming we have a table named 'my_table'
    private static final String TABLE_NAME = "my_table";

    public static void main(String[] args) {
        try {
            handleIntegrity();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void handleIntegrity() throws SQLException {
        String query = "SELECT COUNT(*) FROM " + TABLE_NAME;
        Connection connection = DriverManager.getConnection("jdbc:your_database_url", "username", "password");

        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query);

        if (resultSet.next()) {
            int count = resultSet.getInt(1);

            if (count > 0) {
                System.out.println("The table integrity is good.");
            } else {
                System.out.println("The table integrity is FAILED.");
                throw new SQLException("The table integrity is FAILED.");
            }
        } else {
            System.out.println("Failed to fetch row count from the table.");
            throw new SQLException("Failed to fetch row count from the table.");
        }

        connection.close();
    }
}