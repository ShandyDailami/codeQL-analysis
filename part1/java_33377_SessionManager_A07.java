import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.Root;
import javax.persistence.Query;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class java_33377_SessionManager_A07 {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/test";
        String username = "root";
        String password = "password";

        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            if (!connection.isValid()) {
                System.out.println("Invalid connection.");
                return;
            }

            SessionFactory sessionFactory = connection.getSessionFactory();
            Session session = sessionFactory.openSession();

            try {
                session.beginTransaction();

                // Example: delete all data from a table
                CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
                CriteriaDelete<User> delete = criteriaBuilder.createCriteriaDelete(User.class);
                Root<User> root = delete.from(User.class);
                delete.where(criteriaBuilder.isNotNull(root.get("id")));
                Query query = criteriaBuilder.createQuery(delete);
                int rowsDeleted = session.createQuery(query).executeUpdate();

                session.getTransaction().commit();

                System.out.println("Rows deleted: " + rowsDeleted);
            } catch (Exception e) {
                if (session.getTransaction() != null) {
                    session.getTransaction().rollback();
                }
                System.out.println("Error: " + e.getMessage());
            }

            session.close();

        } catch (SQLException e) {
            System.out.println("SQL Exception: " + e.getMessage());
        }
    }
}