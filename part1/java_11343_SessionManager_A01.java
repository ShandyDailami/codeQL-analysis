public class java_11343_SessionManager_A01 {
    private static int nextID = 1;
    private ArrayList<Session> sessions = new ArrayList<Session>();

    public Session createSession() {
        Session s = new Session(nextID++, "Guest" + nextID);
        sessions.add(s);
        return s;
    }

    public Session getSession(int id) {
        for (Session s : sessions) {
            if (s.getId() == id) {
                return s;
            }
        }
        return null;
    }

    public void closeSession(Session s) {
        sessions.remove(s);
    }
}

class Session {
    private int id;
    private String name;

    public java_11343_SessionManager_A01(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }
}