public class java_40022_SessionManager_A07 {
    private static final String PATTERN = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&*-])(?=\\S+$).{8,}$";
    private static final String AUTH_FAILURE_MESSAGE = "Authentication failure";
    private static final String SUCCESS_MESSAGE = "Successfully logged in";
    private static SessionManager instance = null;

    private java_40022_SessionManager_A07() {}

    public static SessionManager getInstance() {
        if (instance == null) {
            instance = new SessionManager();
        }
        return instance;
    }

    public String login(String username, String password) {
        if (!validatePassword(password)) {
            return AUTH_FAILURE_MESSAGE;
        }

        // Here you should perform the actual authentication. This is a dummy operation.
        if (username.equals("admin")) {
            return SUCCESS_MESSAGE;
        } else {
            return AUTH_FAILURE_MESSAGE;
        }
    }

    private boolean validatePassword(String password) {
        return password.matches(PATTERN);
    }
}