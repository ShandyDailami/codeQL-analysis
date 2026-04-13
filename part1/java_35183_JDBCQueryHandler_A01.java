import java.sql.*;

public class java_35183_JDBCQueryHandler_A01 {

    private Connection connection;

    public java_35183_JDBCQueryHandler_A01() {
        this.connection = this.getConnection();
    }

    private Connection getConnection() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_name", "username", "password");
        } catch (SQLException e) {
            e.printStackTrace();
            System.exit(1);
       
        }
        return conn;
    }

    public void executeQuery(String query) {
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                // Print the result set data
                System.out.println(rs.getString("column_name"));
            }

            rs.close();
            stmt.close();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Close the database connection
            this.closeConnection();
        }
    }

    private void closeConnection() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        JDBCQueryHandler jdbcQueryHandler = new JDBCQueryHandler();
        jdbcQueryHandler.executeQuery("SELECT * FROM users");
    }
}