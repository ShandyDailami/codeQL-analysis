import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.transaction.Transaction;
import javax.transaction.Transactional;

public class java_02932_SessionManager_A01 {

    private static EntityManagerFactory entityManagerFactory;

    static {
        entityManagerFactory = Persistence.createEntityManagerFactory("jpa_unit");
    }

    public static void main(String[] args) {
        runBrokenAccessControlOperation();
    }

    @Transactional
    public static void runBrokenAccessControlOperation() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Transaction transaction = entityManager.getTransaction();

        transaction.begin();

        //Broken Access Control Operation
        User user = entityManager.find(User.class, 1);
        user.setName("New Name");

        transaction.commit();
        entityManager.close();
    }
}