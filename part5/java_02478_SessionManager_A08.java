import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class java_02478_SessionManager_A08 {
    private static final String URL = "jdbc:mysql://localhost:3306/mydb";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    private Connection connection;

    public java_02478_SessionManager_A08() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public void createSession() {
        String sql = "INSERT INTO session (id) VALUES (?)";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, (int) (Math.random() * 100));
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void readSession() {
        String sql = "SELECT * FROM session WHERE id = ?";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, (int) (Math.random() * 100));
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                System.out.println("Session ID: " + result.getInt("id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateSession() {
        String sql = "UPDATE session SET id = ? WHERE id = ?";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, (int) (Math.random() * 100));
            statement.setInt(2, (int) (Math.random() * 100));
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteSession() {
        String sql = "DELETE FROM session WHERE id = ?";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, (int) (Math.random() * 100));
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void closeConnection() {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();
        sessionManager.createSession();
        sessionManager.readSession();
        sessionManager.updateSession();
        sessionManager.deleteSession();
        sessionManager.closeConnection();
    }
}