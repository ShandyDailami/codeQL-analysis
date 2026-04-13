public class java_23992_SessionManager_A08 {
    private Session session;
    private Transaction transaction;

    // Constructor
    public java_23992_SessionManager_A08() {
        this.session = HibernateUtil.getSessionFactory().openSession();
    }

    // Method to start a transaction
    public void beginTransaction() {
        try {
            transaction = session.beginTransaction();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Method to commit a transaction
    public void commitTransaction() {
        try {
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Method to rollback a transaction
    public void rollbackTransaction() {
        try {
            transaction.rollback();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Method to save an object
    public void save(Object obj) {
        try {
            session.save(obj);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Method to update an object
    public void update(Object obj) {
        try {
            session.update(obj);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Method to delete an object
    public void delete(Object obj) {
        try {
            session.delete(obj);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Method to retrieve an object
    public Object get(Class cls, Long id) {
        try {
            return session.get(cls, id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    // Method to retrieve all objects of a particular class
    public List<Object> getAll(Class cls) {
        try {
            Criteria criteria = session.createCriteria(cls);
            criteria.add(Restrictions.gt("id", 10000)); // add restriction to limit the results
            return criteria.list();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}