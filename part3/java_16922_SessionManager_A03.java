import java.util.List;

public class java_16922_SessionManager_A03 {
    private UserRepository userRepository;
    private SessionFactory sessionFactory;

    public java_16922_SessionManager_A03(UserRepository userRepository, SessionFactory sessionFactory) {
        this.userRepository = userRepository;
        this.sessionFactory = sessionFactory;
    }

    public User getUserById(int id) {
        Session session = sessionFactory.openSession();
        User user = session.get(User.class, id);
        session.close();
        return user;
    }

    public List<User> getAllUsers() {
        Session session = sessionFactory.openSession();
        List<User> users = session.createQuery("from User", User.class).list();
        session.close();
        return users;
    }

    public void saveUser(User user) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(user);
        session.getTransaction().commit();
        session.close();
    }

    public void updateUser(User user) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.update(user);
        session.getTransaction().commit();
        session.close();
    }

    public void deleteUser(int id) {
        Session session = sessionFactory.openSession();
        User user = session.get(User.class, id);
        session.beginTransaction();
        session.delete(user);
        session.getTransaction().commit();
        session.close();
    }
}