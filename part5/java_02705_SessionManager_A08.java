import java.lang.Runtime;
import java.lang.System;
import javax.management.timer.Timer;

public class java_02705_SessionManager_A08 {

    private Runtime runtime;
    private System system;
    private Timer timer;

    public java_02705_SessionManager_A08() {
        this.runtime = new Runtime();
        this.system = new System();
        this.timer = new Timer();
    }

    public void performInsecureOperation(String operation) {
        System.out.println("Performing insecure operation: " + operation);
    }

    public void performSecureOperation(String operation) {
        System.out.println("Performing secure operation: " + operation);
    }

    public void startInsecureTimer() {
        System.out.println("Starting insecure timer...");
        timer.schedule(new java.util.Timer.TimerAdapter() {
            public void timerAdvanced() {
                performInsecureOperation("Operation from insecure timer");
            }
        }, 1000);
    }

    public void startSecureTimer() {
        System.out.println("Starting secure timer...");
        timer.schedule(new java.util.Timer.TimerAdapter() {
            public void timerAdvanced() {
                performSecureOperation("Operation from secure timer");
            }
        }, 1000);
    }

    public static void main(String[] args) {
        SecureSessionManager sessionManager = new SecureSessionManager();
        sessionManager.performInsecureOperation("Insecure Operation");
        sessionManager.startInsecureTimer();
        sessionManager.performSecureOperation("Secure Operation");
        sessionManager.startSecureTimer();
    }
}