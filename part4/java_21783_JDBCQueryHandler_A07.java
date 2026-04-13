public class java_21783_JDBCQueryHandler_A07 implements UserDao {

    private ConnectionManager connectionManager;

    public java_21783_JDBCQueryHandler_A07(ConnectionManager connectionManager) {
        this.connectionManager = connectionManager;
    }

    @Override
    public User findUserById(int id) {
        User user = null;
        try (Connection connection = connectionManager.getConnection()) {
            String sql = "SELECT * FROM Users WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                user = new User();
                user.setId(resultSet.getInt("id"));
                user.setUsername(resultSet.getString("username"));
                user.setPassword(resultSet.getString("password"));
            }
        } catch (SQLException e) {
            // Handle exception here
        }
        return user;
    }
}