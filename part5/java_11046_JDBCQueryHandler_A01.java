import java.sql.*;

public class java_11046_JDBCQueryHandler_A01 {
    private Connection connection;
    private Statement statement;

    public java_11046_JDBCQueryHandler_A01(String dbURL, String userName, String password) {
        try {
            this.connection = DriverManager.getConnection(dbURL, userName, password);
            this.statement = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ResultSet executeQuery(String query) {
        try {
            return this.statement.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public int executeUpdate(String query) {
        try {
            return this.statement.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }
    }

    public void closeConnection() {
        try {
            if (this.statement != null) {
                this.statement.close();
            }
            if (this.connection != null) {
                this.connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        VanillaJavaJDBCQueryHandler jdbcHandler = new VanillaJavaJDBCQueryHandler("jdbc:mysql://localhost:3306/test", "username", "password");
        ResultSet rs = jdbcHandler.executeQuery("SELECT * FROM Users");
        while (rs.next()) {
            System.out.println(rs.getString("username"));
        }
        jdbcHandler.closeConnection();
    }
}