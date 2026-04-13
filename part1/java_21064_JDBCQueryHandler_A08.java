import java.sql.*;

public class java_21064_JDBCQueryHandler_A08 {
    private Connection connection;

    public java_21064_JDBCQueryHandler_A08(String url, String username, String password) throws SQLException {
        this.connection = DriverManager.getConnection(url, username, password);
    }

    public void executeQuery(String sql) throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);

        while (resultSet.next()) {
            // Accessing data
            String username = resultSet.getString("username");
            String password = resultSet.getString("password");

            // Security-sensitive operation related to A08_IntegrityFailure
            // No logging or displaying of passwords, only integrity checking
            // Replace the password with a hash or similar if you want to ensure integrity
            if (password.equals("securePassword")) {
                System.out.println("Password match detected!");
            }
        }

        resultSet.close();
        statement.close();
    }

    public void closeConnection() throws SQLException {
        connection.close();
    }
}