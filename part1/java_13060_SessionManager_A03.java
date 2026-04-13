import javax.persistence.*;

public class java_13060_SessionManager_A03 {

    public static void main(String[] args) {
        // Create a new session factory
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("test");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        // Begin a transaction
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        // Create a new user
        User user = new User("John", "Doe", "john@example.com");

        // Create a new role
        Role role = new Role("admin");

        // Add the user and role to the session
        entityManager.persist(user);
        entityManager.persist(role);
        entityManager.flush();

        // Add the role to the user
        user.getRoles().add(role);

        // Commit the changes
        transaction.commit();
        entityManager.close();
        entityManagerFactory.close();
    }
}

@Entity
class User {
    @Id @GeneratedValue
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
        name = "user_roles",
        joinColumns = { @JoinColumn(name = "user_id") },
        inverseJoinColumns = { @JoinColumn(name = "role_id") }
    )
    private Collection<Role> roles;

    User(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public Collection<Role> getRoles() {
        return roles;
    }
}

@Entity
class Role {
    @Id @GeneratedValue
    private Long id;
    private String roleName;
    @ManyToMany(mappedBy = "roles")
    private Collection<User> users;

    Role(String roleName) {
        this.roleName = roleName;
    }

    public Collection<User> getUsers() {
        return users;
    }
}