import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class java_38948_JDBCQueryHandler_A01 {

    private Connection connection;

    public java_38948_JDBCQueryHandler_A01(String dbUrl, String user, String password) throws SQLException {
        this.connection = DriverManager.getConnection(dbUrl, user, password);
    }

    public ResultSet executeQuery(String query) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        return preparedStatement.executeQuery();
    }

    public void executeUpdate(String query) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.executeUpdate();
    }

    public void closeConnection() throws SQLException {
        connection.close();
    }

    public static void main(String[] args) {
        String dbUrl = "jdbc:mysql://localhost:3306/test";
        String user = "root";
        String password = "password";

        try {
            JDBCQueryHandler jdbcQueryHandler = new JDBCQueryHandler(dbUrl, user, password);

            String query = "SELECT * FROM Users WHERE username = ?";
            PreparedStatement preparedStatement = jdbcQueryHandler.connection.prepareStatement(query);
            preparedStatement.setString(1, "admin");

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                System.out.println(resultSet.getString("password"));
            }

            jdbcQueryHandler.closeConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}