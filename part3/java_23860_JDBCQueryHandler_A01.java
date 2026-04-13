import java.sql.*;

public class java_23860_JDBCQueryHandler_A01 {

    private static final String URL = "jdbc:mysql://localhost:3306/mydb";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            createTables(connection);
            insertData(connection);
            queryData(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void createTables(Connection connection) throws SQLException {
        String createUsersTable = "CREATE TABLE Users (" +
                "id INT AUTO_INCREMENT PRIMARY KEY," +
                "username VARCHAR(50) NOT NULL," +
                "password VARCHAR(50) NOT NULL)";
        String createRolesTable = "CREATE TABLE Roles (" +
                "id INT AUTO_INCREMENT PRIMARY KEY," +
                "roleName VARCHAR(50) NOT NULL)";
        String createUserRoleTable = "CREATE TABLE UserRole (" +
                "id INT AUTO_INCREMENT PRIMARY KEY," +
                "userId INT," +
                "roleId INT," +
                "FOREIGN KEY(userId) REFERENCES Users(id)," +
                "FOREIGN KEY(roleId) REFERENCES Roles(id))";

        try (Statement statement = connection.createStatement()) {
            statement.execute(createUsersTable);
            statement.execute(createRolesTable);
            statement.execute(createUserRoleTable);
        }
    }

    private static void insertData(Connection connection) throws SQLException {
        String insertUser = "INSERT INTO Users (username, password) VALUES ('user1', 'password1')";
        String insertRole = "INSERT INTO Roles (roleName) VALUES ('ROLE_USER')";
        String insertUserRole = "INSERT INTO UserRole (userId, roleId) VALUES ('1', '1')";

        try (Statement statement = connection.createStatement()) {
            statement.execute(insertUser);
            statement.execute(insertRole);
            statement.execute(insertUserRole);
        }
    }

    private static void queryData(Connection connection) throws SQLException {
        String queryUsers = "SELECT * FROM Users";
        String queryRoles = "SELECT * FROM Roles";
        String queryUserRole = "SELECT * FROM UserRole";

        try (Statement statement = connection.createStatement()) {
            ResultSet resultSetUsers = statement.executeQuery(queryUsers);
            ResultSet resultSetRoles = statement.executeQuery(queryRoles);
            ResultSet resultSetUserRole = statement.executeQuery(queryUserRole);

            while (resultSetUsers.next()) {
                System.out.println("User ID: " + resultSetUsers.getInt("id"));
                System.out.println("Username: " + resultSetUsers.getString("username"));
                System.out.println("Password: " + resultSetUsers.getString("password"));
            }

            while (resultSetRoles.next()) {
                System.out.println("Role ID: " + resultSetRoles.getInt("id"));
                System.out.println("Role Name: " + resultSetRoles.getString("roleName"));
            }

            while (resultSetUserRole.next()) {
                System.out.println("User ID: " + resultSetUserRole.getInt("userId"));
                System.out.println("Role ID: " + resultSetUserRole.getInt("roleId"));
            }
        }
    }
}