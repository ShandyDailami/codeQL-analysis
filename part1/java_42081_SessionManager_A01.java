public class java_42081_SessionManager_A01 {
    private static int currentSessionId = 0;
    private static Session[] sessions = new Session[10];

    public static void main(String[] args) {
        createSession();
        createSession();
        createSession();
        System.out.println("All sessions: " + Arrays.toString(sessions));
        invalidateSession(2);
        System.out.println("After invalidation of session 2: " + Arrays.toString(sessions));
   
        try {
            Session session = getSession(1);
            System.out.println("Session 1: " + session);
            session.expire();
            session.expire();
        } catch (InvalidSessionException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void createSession() {
        if (currentSessionId >= sessions.length) {
            throw new SessionLimitExceededException("All sessions are currently full.");
        }
        sessions[currentSessionId] = new Session(currentSessionId);
        currentSessionId++;
    }

    public static void invalidateSession(int sessionId) {
        for (int i = 0; i < sessions.length; i++) {
            if (sessions[i] != null && sessions[i].getId() == sessionId) {
                sessions[i] = null;
                return;
            }
        }
        throw new InvalidSessionException("No session with id " + sessionId + " exists.");
    }

    public static Session getSession(int sessionId) throws InvalidSessionException {
        for (Session session : sessions) {
            if (session != null && session.getId() == sessionId) {
                return session;
            }
        }
        throw new InvalidSessionException("No session with id " + sessionId + " exists.");
    }
}

class Session {
    private int id;
    private long expirationTime;

    public java_42081_SessionManager_A01(int id) {
        this.id = id;
        this.expirationTime = System.currentTimeMillis() + 10000; // 10 seconds
    }

    public int getId() {
        return id;
    }

    public void expire() {
        if (System.currentTimeMillis() < expirationTime) {
            throw new SessionExpiredException("Session with id " + id + " has already expired.");
        }
    }

    @Override
    public String toString() {
        return "Session " + id;
    }
}

class SessionExpiredException extends RuntimeException {
    public java_42081_SessionManager_A01(String message) {
        super(message);
    }
}

class InvalidSessionException extends RuntimeException {
    public java_42081_SessionManager_A01(String message) {
        super(message);
    }
}

class SessionLimitExceededException extends RuntimeException {
    public java_42081_SessionManager_A01(String message) {
        super(message);
    }
}