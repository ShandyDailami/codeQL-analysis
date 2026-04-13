import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class java_41463_SessionManager_A07 {

    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

        // Start a session
        Session session = sessionFactory.openSession();

        // Begin a transaction
        session.beginTransaction();

        // Perform CRUD operations
        // Create
        session.save(new Person("John", "Doe"));

        // Retrieve
        Person person = session.get(Person.class, 1);
        System.out.println(person.getFirstName() + " " + person.getLastName());

        // Update
        person.setFirstName("Jane");
        session.update(person);

        // Delete
        session.delete(person);

        // Commit the transaction
        session.getTransaction().commit();

        // Close the session
        session.close();
    }
}

class Person {
    private String firstName;
    private String lastName;

    public java_41463_SessionManager_A07(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}