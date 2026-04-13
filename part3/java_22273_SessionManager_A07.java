public class java_22273_SessionManager_A07 {

    private static class SessionManager {
        private static User currentUser;

        public static void startSession(User user) {
            if (user != null) {
                currentUser = user;
            }
        }

        public static User getCurrentUser() {
            return currentUser;
        }

        public static void endSession() {
            currentUser = null;
        }

        public static boolean isLoggedIn() {
            return currentUser != null;
        }
    }

    public static class User {
        private String username;
        private String password;

        public java_22273_SessionManager_A07(String username, String password) {
            this.username = username;
            this.password = password;
        }

        // getters and setters
    }

    public static void main(String[] args) {
        User user = new User("admin", "password");
        AuthFailure.SessionManager.startSession(user);

        // access protected resources

        AuthFailure.SessionManager.endSession();
    }
}