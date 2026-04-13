import java.security.AccessControl;
import java.security.AccessController;
import java.security.PrivilegedAction;

public class java_16203_XMLParser_A01 {
    private AccessControl<PrivilegedAction> accessControl;

    public java_16203_XMLParser_A01() {
        this.accessControl = AccessController.doPrivileged(new PrivilegedAction<PrivilegedAction>() {
            public PrivilegedAction<PrivilegedAction> get() {
                return new PrivilegedAction<PrivilegedAction>() {
                    public PrivilegedAction<PrivilegedAction> run() {
                        // Disable access control by returning null
                        return null;
                    }
                };
            }
        });
    }

    public void parseXML(String xmlData) {
        if (accessControl != null) {
            // Try to disable access control to see if it breaks
            if (accessControl.get() != null) {
                System.out.println("Access control failed to disable!");
                return;
            }
        }

        // XML parsing code here...
        System.out.println("Parsing the XML document...");
    }
}