import java.security.Permission;
import java.security.SecurityPermission;

public class java_19045_XMLParser_A01 {

    public static void main(String[] args) {
        try {
            SecurityManager sm = new SecurityManager() {
                @Override
                public void checkPermission(Permission perm) {
                    if (perm instanceof SecurityPermission) {
                        throw new SecurityException("Broken!");
                    }
                }

                @Override
                public void checkActions(String actions) {
                    throw new SecurityException("Broken!");
                }
            };
            System.setSecurityManager(sm);

            // Attempt to access a method or class that violates the security policy
            createInvalidXMLParser();
        } catch (SecurityException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static class InvalidXMLParser {
        public void parse() {
            // Some code here
        }
    }

    public static void createInvalidXMLParser() {
        InvalidXMLParser ip = new InvalidXMLParser();
        ip.parse();
    }
}