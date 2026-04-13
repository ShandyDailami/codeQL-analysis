public class java_40750_SessionManager_A07 {
    // Simplified authentication system for demonstration purposes.
    private boolean isAuthenticated = false;

    public void setUserAsAuthenticated(boolean authenticated) {
        isAuthenticated = authenticated;
    }

    public void accessResource(String resource) {
        if (!isAuthenticated) {
            throw new SecurityException("User is not authenticated.");
        }

        // Simulate access to a resource.
        System.out.println("Accessing " + resource + "...");
    }
}