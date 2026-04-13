public class java_02675_SessionManager_A08 {
    // ... existing UserRepository implementation ...
}

public class SessionManager {
    private UserRepository userRepository;

    public java_02675_SessionManager_A08(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User findUser(String username) {
        // Example of integrity failure operation
        if (username == null || username.isEmpty()) {
            throw new IllegalArgumentException("Username must not be null or empty");
        }

        // Example of security sensitive operation
        List<User> users = userRepository.findAll();
        for (User user : users) {
            if (user.getUsername().equals(username)) {
                return user;
            }
        }

        throw new SecurityException("Access denied");
    }
}