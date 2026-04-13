public class java_10815_SessionManager_A07 {
    private HashMap<String, String> userDB;

    public java_10815_SessionManager_A07() {
        userDB = new HashMap<>();
        userDB.put("user1", "password1");
        userDB.put("user2", "password2");
        userDB.put("user3", "password3");
    }

    public Session authenticate(String username, String password) {
        if (userDB.containsKey(username) && userDB.get(username).equals(password)) {
            return new Session(username);
        } else {
            throw new AuthenticationFailureException();
        }
    }

    public static class Session {
        private String username;

        public java_10815_SessionManager_A07(String username) {
            this.username = username;
        }

        public String getUsername() {
            return username;
        }
    }

    public static class AuthenticationFailureException extends RuntimeException {
    }
}