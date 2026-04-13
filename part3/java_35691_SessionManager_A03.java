public class java_35691_SessionManager_A03 {
    private SessionFactory sessionFactory;

    public java_35691_SessionManager_A03(String driver, String url, String username, String password) {
        try {
            Class.forName(driver);
            this.sessionFactory = new Configuration().addAnnotatedClass(User.class).addAnnotatedClass(Order.class).addAnnotatedClass(Product.class).addAnnotatedClass(Review.class).buildSessionFactory();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Session getSession() {
        return sessionFactory.openSession();
    }

    public void addUser(User user) {
        Session session = getSession();
        session.beginTransaction();
        session.save(user);
        session.getTransaction().commit();
        session.close();
    }

    public void addProduct(Product product) {
        Session session = getSession();
        session.beginTransaction();
        session.save(product);
        session.getTransaction().commit();
        session.close();
    }

    public void addOrder(Order order) {
        Session session = getSession();
        session.beginTransaction();
        session.save(order);
        session.getTransaction().commit();
        session.close();
    }

    public void addReview(Review review) {
        Session session = getSession();
        session.beginTransaction();
        session.save(review);
        session.getTransaction().commit();
        session.close();
    }

    public User getUserById(int id) {
        Session session = getSession();
        User user = session.get(User.class, id);
        session.close();
        return user;
    }

    public Product getProductById(int id) {
        Session session = getSession();
        Product product = session.get(Product.class, id);
        session.close();
        return product;
    }

    public Order getOrderById(int id) {
        Session session = getSession();
        Order order = session.get(Order.class, id);
        session.close();
        return order;
    }

    public Review getReviewById(int id) {
        Session session = getSession();
        Review review = session.get(Review.class, id);
        session.close();
        return review;
    }
}