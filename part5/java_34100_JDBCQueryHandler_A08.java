import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class java_34100_JDBCQueryHandler_A08 {

    private static final String URL = "jdbc:mysql://localhost:3306/test";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        try {
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
            Statement statement = connection.createStatement();

            // Fetch users
            ResultSet resultSet = statement.executeQuery("SELECT * FROM users");
            List<User> users = new ArrayList<>();
            while (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getInt("id"));
                user.setName(resultSet.getString("name"));
                users.add(user);
            }

            // Modify user
            User userToUpdate = users.get(0); // Just pick an user for example
            userToUpdate.setName(null); // Nullify name

            // Insert modified user back into database
            String insertQuery = "INSERT INTO users (id, name) VALUES (" + userToUpdate.getId() + ", '" + userToUpdate.getName() + "')";
            statement.executeUpdate(insertQuery);

            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    static class User {
        private int id;
        private String name;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}