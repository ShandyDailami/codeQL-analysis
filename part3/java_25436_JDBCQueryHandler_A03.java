import java.sql.*;

public class java_25436_JDBCQueryHandler_A03 {

    private Connection connection;
    private String dbUrl;
    private String username;
    private String password;

    public java_25436_JDBCQueryHandler_A03(String dbUrl, String username, String password) {
        this.dbUrl = dbUrl;
        this.username = username;
        this.password = password;
    }

    public void openConnection() throws SQLException {
        connection = DriverManager.getConnection(dbUrl, username, password);
    }

    public void executeQuery(String query) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            // TODO: Handle the result set
        }

        resultSet.close();
        preparedStatement.close();
    }

    public void closeConnection() throws SQLException {
        connection.close();
    }

    public static void main(String[] args) {
        String dbUrl = "jdbc:mysql://localhost:3306/test";
        String username = "root";
        String password = "password";

        JDBCQueryHandler queryHandler = new JDBCQueryHandler(dbUrl, username, password);

        try {
            queryHandler.openConnection();
            queryHandler.executeQuery("SELECT * FROM users WHERE username = ?");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                queryHandler.closeConnection();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}