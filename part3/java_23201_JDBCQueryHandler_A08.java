import java.sql.*;

public class java_23201_JDBCQueryHandler_A08 {
    private static final String url = "jdbc:mysql://localhost:3306/database_name";
    private static final String username = "username";
    private static final String password = "password";
    private Connection connection = null;

    public void openConnection() {
        try {
            this.connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void closeConnection() {
        if (this.connection != null) {
            try {
                this.connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public ResultSet executeQuery(String query) {
        try {
            if (this.connection != null) {
                PreparedStatement statement = this.connection.prepareStatement(query);
                return statement.executeQuery();
            } else {
                throw new SQLException("Connection was not opened.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public int executeUpdate(String query) {
        try {
            if (this.connection != null) {
                PreparedStatement statement = this.connection.prepareStatement(query);
                return statement.executeUpdate();
            } else {
                throw new SQLException("Connection was not opened.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }
    }
}