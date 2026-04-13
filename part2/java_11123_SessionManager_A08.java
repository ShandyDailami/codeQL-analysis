import java.sql.*;

public class java_11123_SessionManager_A08 {
    private static final String URL = "jdbc:mysql://localhost:3306/test";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        try {
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);

            // Start a new transaction
            connection.setAutoCommit(false);

            // Create a new session
            Session session = new Session(connection);

            // Create a new record
            session.createRecord(1, "test", "test");

            // Fetch the record
            ResultSet resultSet = session.fetchRecord(1);

            // Update the record
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                System.out.println("Name: " + name);
            }

            // Commit the transaction
            connection.commit();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

class Session {
    private Connection connection;

    public java_11123_SessionManager_A08(Connection connection) {
        this.connection = connection;
    }

    public void createRecord(int id, String name, String address) throws SQLException {
        String query = "INSERT INTO people (id, name, address) VALUES (" + id + ", '" + name + "', '" + address + "')";
        connection.prepareStatement(query).execute();
    }

    public ResultSet fetchRecord(int id) throws SQLException {
        String query = "SELECT name, address FROM people WHERE id = " + id;
        return connection.prepareStatement(query).executeQuery();
    }
}