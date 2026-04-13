import java.sql.*;

public class java_21060_JDBCQueryHandler_A08 {
    private Connection connection;

    public java_21060_JDBCQueryHandler_A08() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            this.connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/db_name", "username", "password");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void createTable() {
        String sql = "CREATE TABLE A08_IntegrityFailure (ID INT PRIMARY KEY, NAME VARCHAR(50))";
        try (Statement statement = connection.createStatement()) {
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insertIntoTable() {
        String sql = "INSERT INTO A08_IntegrityFailure (ID, NAME) VALUES (1, 'John')";
        try (Statement statement = connection.createStatement()) {
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void selectFromTable() {
        String sql = "SELECT * FROM A08_IntegrityFailure";
        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                System.out.println(resultSet.getString("ID") + " " + resultSet.getString("NAME"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateInTable() {
        String sql = "UPDATE A08_IntegrityFailure SET NAME = 'Jane' WHERE ID = 1";
        try (Statement statement = connection.createStatement()) {
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteFromTable() {
        String sql = "DELETE FROM A08_IntegrityFailure WHERE ID = 1";
        try (Statement statement = connection.createStatement()) {
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}