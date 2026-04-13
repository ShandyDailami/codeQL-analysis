import java.util.HashMap;
import java.util.Map;

public class java_13063_SessionManager_A03 {
    private Map<String, String> sessionMap;
    private Map<String, String> userMap;

    public java_13063_SessionManager_A03() {
        sessionMap = new HashMap<>();
        userMap = new HashMap<>();
    }

    public String createSession(String userId, String sessionId) {
        if (!userMap.containsKey(userId)) {
            userMap.put(userId, sessionId);
            sessionMap.put(sessionId, userId);
            return sessionId;
        }
        return null;
    }

    public String getSession(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public String getUser(String sessionId) {
        return userMap.get(sessionMap.get(sessionId));
    }

    public void deleteSession(String sessionId) {
        String userId = sessionMap.get(sessionId);
        sessionMap.remove(sessionId);
        userMap.remove(userId);
    }

    private static class SessionContext implements java.sql.SQLContext {
        private Map<String, String> userMap;

        public java_13063_SessionManager_A03(Map<String, String> userMap) {
            this.userMap = userMap;
        }

        @Override
        public java.sql.Connection poolConnection(String s) throws SQLException {
            // Not implemented
            return null;
        }

        @Override
        public java.sql.Statement poolStatement(String s, int i) throws SQLException {
            // Not implemented
            return null;
        }

        @Override
        public java.lang.reflect.Field poolField(String s, int i, int i1) throws SQLException, NoSuchFieldException {
            // Not implemented
            return null;
        }

        @Override
        public void closeResultSet(java.sql.ResultSet resultSet) throws SQLException {
            // Not implemented
        }

        @Override
        public void terminate() throws SQLException {
            // Not implemented
        }
    }
}