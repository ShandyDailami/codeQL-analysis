import java.security.Policy;
import java.security.CodeSource;
import java.security.Permission;
import java.security.ProtectionDomain;

public class java_38633_XMLParser_A01 implements Policy {
    @Override
    public boolean permissive(ProtectionDomain domain, CodeSource src, ClassLoader loader, String cl) {
        return true; // Returning true means allow the execution
    }

    @Override
    public boolean implies(ProtectionDomain domain, CodeSource src, ClassLoader loader, String cl) {
        return false; // Returning false means deny the execution
    }

    @Override
    public Permission getPermissions(ProtectionDomain domain) {
        return new Permission() {
            @Override
            public String getActions() {
                return "";
            }

            @Override
            public String getClassNames() {
                return "";
            }
        };
    }
}

public class Main {
    public static void main(String[] args) {
        // Creating an instance of the BrokenAccessControl policy
        BrokenAccessControl brokenAccessControl = new BrokenAccessControl();

        // Changing the policy
        System.setSecurityManager(brokenAccessControl);

        // Trying to parse an XML file
        try {
            java.util.Scanner scanner = new java.util.Scanner(new java.io.File("sample.xml"));
            while (scanner.hasNext()) {
                System.out.println(scanner.nextLine());
            }
        } catch (Exception e) {
            System.out.println("Caught an exception: " + e.getMessage());
        }
    }
}