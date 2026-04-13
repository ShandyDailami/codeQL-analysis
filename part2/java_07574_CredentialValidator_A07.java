import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class java_07574_CredentialValidator_A07 {

    private SessionFactory sessionFactory;

    public java_07574_CredentialValidator_A07() {
        Configuration configuration = new Configuration();
        configuration.configure();
        sessionFactory = configuration.buildSessionFactory();
    }

    public boolean validate(String username, String password) {
        Session session = sessionFactory.openSession();
        try {
            Query query = session.createQuery("from User where username = :username");
            query.setParameter("username", username);
            User user = (User) query.uniqueResult();
            if (user != null && user.getPassword().equals(password)) {
                return true;
            }
        } finally {
            session.close();
        }
        return false;
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();
        System.out.println(validator.validate("admin", "password"));
    }
}