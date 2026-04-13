public class java_15755_SessionManager_A01 {
    private Map<String, String> userMap;

    public java_15755_SessionManager_A01() {
        userMap = new HashMap<>();
        userMap.put("admin", "ROLE_ADMIN");
        userMap.put("user", "ROLE_USER");
    }

    public String openSession(String username) {
        if (userMap.containsKey(username) && "ROLE_ADMIN".equals(userMap.get(username))) {
            return "Admin session opened for user: " + username;
        } else {
            return "User session opened for user: " + username;
        }
    }
}