import java.sql.*;

public class java_13015_JDBCQueryHandler_A01 {

    private Connection connection;
    private Statement statement;

    public java_13015_JDBCQueryHandler_A01() {
        this.connection = null;
        this.statement = null;
    }

    public void connectToDatabase(String dbUrl, String dbUser, String dbPassword) {
        try {
            this.connection = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
            this.statement = this.connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ResultSet executeQuery(String query) {
        ResultSet resultSet = null;
        try {
            resultSet = this.statement.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultSet;
    }

    public void closeConnection() {
        try {
            this.connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        JDBCQueryHandler jdbcQueryHandler = new JDBCQueryHandler();
        jdbcQueryHandler.connectToDatabase("jdbc:mysql://localhost:3306/mydb", "myUser", "myPassword");

        String query = "SELECT * FROM myTable";
        ResultSet resultSet = jdbcQueryHandler.executeQuery(query);

        // Process the result set
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            System.out.println("ID: " + id + ", Name: " + name);
        }

        jdbcQueryHandler.closeConnection();
    }
}