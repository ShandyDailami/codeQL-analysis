import java.util.ArrayList;
import java.util.List;

public class java_19203_SessionManager_A03 {

    private List<String> sessionList;

    public java_19203_SessionManager_A03() {
        this.sessionList = new ArrayList<>();
    }

    public void addSession(String session) {
        sessionList.add(session);
    }

    public String getSession(int index) {
        if(index < 0 || index >= sessionList.size()) {
            throw new IllegalArgumentException("Index out of bounds");
        }
        return sessionList.get(index);
    }

    public void removeSession(int index) {
        if(index < 0 || index >= sessionList.size()) {
            throw new IllegalArgumentException("Index out of bounds");
        }
        sessionList.remove(index);
    }

    public int getSize() {
        return sessionList.size();
    }
}