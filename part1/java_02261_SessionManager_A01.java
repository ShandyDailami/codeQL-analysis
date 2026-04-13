public class java_02261_SessionManager_A01 {
    private static int sessionCount = 0;

    public static Session openSession() {
        Session session = new MySession();
        session.setId("session-" + (++sessionCount));
        return session;
    }

    private static class MySession implements Session {
        private String id;

        @Override
        public String getId() {
            return id;
        }

        @Override
        public void setId(String id) {
            this.id = id;
        }
    }
}