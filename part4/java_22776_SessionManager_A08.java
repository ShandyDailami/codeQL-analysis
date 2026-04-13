public class java_22776_SessionManager_A08 {

    // This is a private field that we'll try to access.
    private String secretInfo;

    public void setSecretInfo(String secretInfo) {
        this.secretInfo = secretInfo;
    }

    public void checkSecretInfo() {
        // Trying to access the private field can cause an exception.
        System.out.println("Secret info: " + secretInfo);
    }
}

public class Main {
    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();
        sessionManager.setSecretInfo("Hello, world!");
        sessionManager.checkSecretInfo();
    }
}