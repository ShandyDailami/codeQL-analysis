import java.util.ArrayList;
import java.util.List;

public class java_17094_SessionManager_A03 {
    private List<String> data = new ArrayList<>();

    // Session start
    public void beginSession() {
        System.out.println("Starting session...");
        data.clear();
    }

    // Session data write
    public void writeSessionData(String input) {
        data.add(input);
        System.out.println("Writing data: " + input);
    }

    // Session data read
    public List<String> readSessionData() {
        System.out.println("Reading data: ");
        return data;
    }

    // Session end
    public void endSession() {
        for (String s : data) {
            System.out.println("Data read: " + s);
        }
        System.out.println("Ending session...");
    }

    public static void main(String[] args) {
        SessionManager sm = new SessionManager();
        sm.beginSession();
        sm.writeSessionData("Hello");
        sm.readSessionData();
        sm.writeSessionData("World");
        sm.readSessionData();
        sm.endSession();
    }
}