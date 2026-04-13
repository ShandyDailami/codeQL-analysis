public class java_09364_SessionManager_A01 {
    private boolean isSessionOpen;

    public java_09364_SessionManager_A01() {
        isSessionOpen = false;
    }

    public void openSession() {
        if (!isSessionOpen) {
            // open the session
            isSessionOpen = true;
            System.out.println("Session opened");
        } else {
            System.out.println("Session already opened");
        }
    }

    public void closeSession() {
        if (isSessionOpen) {
            // close the session
            isSessionOpen = false;
            System.out.println("Session closed");
        } else {
            System.out.println("Session already closed");
        }
    }

    public boolean isSessionOpen() {
        return isSessionOpen;
    }
}