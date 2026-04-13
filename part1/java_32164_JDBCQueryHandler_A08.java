import java.sql.*;

public class java_32164_JDBCQueryHandler_A08 {
    private Connection connection;

    public java_32164_JDBCQueryHandler_A08(String url, String username, String password) throws SQLException {
        this.connection = DriverManager.getConnection(url, username, password);
    }

    public ResultSet executeQuery(String query) throws SQLException {
        Statement statement = connection.createStatement();
        return statement.executeQuery(query);
    }

    public void executeUpdate(String update) throws SQLException {
        Statement statement = connection.createStatement();
        statement.executeUpdate(update);
    }

    public void closeConnection() throws SQLException {
        connection.close();
    }

    public static void main(String[] args) {
        try {
            new VanillaJDBCQueryHandler("jdbc:mysql://localhost:3306/testdb", "username", "password")
                    .executeUpdate("CREATE TABLE sample_table (id INT PRIMARY KEY, name VARCHAR(255), age INT)");

            ResultSet resultSet = new VanillaJDBCQueryHandler("jdbc:mysql://localhost:3306/testdb", "username", "password")
                    .executeQuery("SELECT * FROM sample_table");

            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                int age = resultSet.getInt(3);
                System.out.println("ID: " + id + ", Name: " + name + ", Age: " + age);
            }

            new VanillaJDBCQueryHandler("jdbc:mysql://localhost:3306/testdb", "username", "password").closeConnection();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}