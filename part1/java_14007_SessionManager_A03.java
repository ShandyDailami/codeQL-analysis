public class java_14007_SessionManager_A03 {
    private SessionFactory sessionFactory;

    public java_14007_SessionManager_A03(String driver, String url, String username, String password) {
        try {
            // Step 1: Define a session factory
            this.sessionFactory = new Configuration().addAnnotatedClass(User.class)
                    .addAnnotatedClass(Role.class)
                    .addAnnotatedClass(UserRole.class)
                    .addAnnotatedClass(Address.class)
                    .addAnnotatedClass(Phone.class)
                    .addAnnotatedClass(Email.class)
                    .addAnnotatedClass(UserDetail.class)
                    .addAnnotatedClass(BillingDetail.class)
                    .addAnnotatedClass(PaymentMethod.class)
                    .addAnnotatedClass(OrderStatus.class)
                    .addAnnotatedClass(PaymentStatus.class)
                    .addAnnotatedClass(OrderDetail.class)
                    .addAnnotatedClass(Product.class)
                    .addAnnotatedClass(Category.class)
                    .addAnnotatedClass(Supplier.class)
                    .addAnnotatedClass(ProductCategory.class)
                    .addAnnotatedClass(ProductSupplier.class)
                    .addAnnotatedClass(ProductDetail.class)
                    .addAnnotatedClass(Review.class)
                    .addAnnotatedClass(Inventory.class)
                    .addAnnotatedClass(InventoryHistory.class)
                    .addAnnotatedClass(InventoryTransaction.class)
                    .buildSessionFactory();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Session openSession() {
        return sessionFactory.openSession();
    }
}