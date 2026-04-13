import java.util.ArrayList;
import java.util.List;

public class java_09365_SessionManager_A01 {
    private List<String> sessions;
    private int currentSessionIndex;

    public java_09365_SessionManager_A01() {
        this.sessions = new ArrayList<>();
        this.currentSessionIndex = 0;
    }

    public void addSession(String session) {
        this.sessions.add(session);
    }

    public String getNextSession() {
        if (this.currentSessionIndex + 1 >= this.sessions.size()) {
            this.currentSessionIndex = 0;
        } else {
            this.currentSessionIndex++;
        }
        return this.sessions.get(this.currentSessionIndex);
    }

    public String getPreviousSession() {
        if (this.currentSessionIndex - 1 < 0) {
            this.currentSessionIndex = this.sessions.size() - 1;
        } else {
            this.currentSessionIndex--;
        }
        return this.sessions.get(this.currentSessionIndex);
    }
}