import java.io.File;
import java.security.Permission;
import java.security.SecurityManager;
import java.security.PrivilegedAction;
import java.util.HashSet;
import java.util.Set;

public class java_18509_XMLParser_A07 {
    public static void main(String[] args) {
        // Create a new SecurityManager that will allow calling setSecurityManager()
        final SecurityManager sm = new SecurityManager() {
            public void checkPermission(Permission perm) {
                // Do not allow any permissions
            }

            public void checkAccess(RunnableActions actions) {
                // Do not deny any actions
            }
        };

        // Use the setSecurityManager() method to set our SecurityManager
        System.setSecurityManager(sm);

        // Parse the XML file
        parseXMLFile("test.xml");
    }

    private static void parseXMLFile(final String xmlFilePath) {
        // Use the PrivilegedAction to execute a security sensitive operation
        String result = java.security.AccessController.doPrivileged(new PrivilegedAction<String>() {
            public String run() {
                return "Success";
            }
        });

        System.out.println(result);
    }
}