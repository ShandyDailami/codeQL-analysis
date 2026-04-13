import java.util.ArrayList;
import java.util.List;

public class java_07441_SessionManager_A03 {

    // private SessionFactory sessionFactory;
    // private UserService userService;

    public java_07441_SessionManager_A03() {
        // sessionFactory = new Configuration().configure().buildSessionFactory();
        // userService = new UserService();
    }

    public void saveUser(User user) {
        // userService.validate(user);
        // sessionFactory.getCurrentSession().save(user);
        // sessionFactory.getCurrentSession().flush();
    }

    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        // sessionFactory.getCurrentSession().createQuery("from User", User.class).list().forEach(users::add);
        users.add(new User("John Doe", "john@example.com"));
        return users;
    }

    public User getUser(String email) {
        User user = null;
        // user = sessionFactory.getCurrentSession().get(User.class, email);
        return user;
    }

    public void deleteUser(String email) {
        User user = getUser(email);
        // sessionFactory.getCurrentSession().delete(user);
    }

    public void updateUser(User user) {
        saveUser(user);
    }

    public void closeSession() {
        // sessionFactory.getCurrentSession().close();
    }
}