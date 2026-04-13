public class java_37779_SessionManager_A07 {
    private Session session;

    public java_37779_SessionManager_A07(String connectionString, String userName, String password) {
        try {
            session = Session.getSession(connectionString, userName, password);
            session.beginTransaction();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void storeData(String data) {
        if (session != null) {
            session.save(new Data(data));
            session.getTransaction().commit();
        }
    }

    public String retrieveData() {
        String data = null;
        if (session != null) {
            data = session.createQuery("from Data", Data.class).getSingleResult().getData();
            session.getTransaction().commit();
        }
        return data;
    }

    public void endSession() {
        if (session != null) {
            session.close();
        }
    }

    public static class Data {
        private String data;

        public java_37779_SessionManager_A07(String data) {
            this.data = data;
        }

        public String getData() {
            return data;
        }

        public void setData(String data) {
            this.data = data;
        }
    }
}