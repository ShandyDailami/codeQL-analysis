import java.util.ArrayList;
import java.util.List;

public class java_17779_SessionManager_A07 {

    private static List<Session> sessions = new ArrayList<>();
    private static long nextSessionId = 1;

    public static class Session {
        public String id;
        public Object data;

        public java_17779_SessionManager_A07(Object data) {
            this.id = "A07_" + nextSessionId++;
            this.data = data;
            sessions.add(this);
        }
    }

    public static void main(String[] args) {
        new Session("Hello, World!");
        new Session("This is a session!");

        System.out.println("Sessions:");
        for (Session session : sessions) {
            System.out.println(session.id + ": " + session.data);
        }
    }
}