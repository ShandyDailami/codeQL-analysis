import java.sql.*;

public class java_30020_JDBCQueryHandler_A08 {

    private Connection connection;
    private Statement statement;

    public java_30020_JDBCQueryHandler_A08() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost/test?useSSL=false&serverTimezone=UTC", "user", "password");
            statement = connection.createStatement();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public ResultSet executeQuery(String query) {
        try {
            return statement.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public int executeUpdate(String query) {
        try {
            return statement.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    public void closeConnection() {
        try {
            if (statement != null)
                statement.close();
            if (connection != null)
                connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        JDBCQueryHandler jdbcHandler = new JDBCQueryHandler();
        ResultSet rs = jdbcHandler.executeQuery("SELECT * FROM Users");
        while (rs.next()) {
            System.out.println(rs.getString("username"));
        }
        jdbcHandler.closeConnection();
    }
}