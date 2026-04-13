import java.io.StringReader;
import java.security.Permission;
import java.security.SecurityManager;
import java.security.PrivilegedAction;

public class java_11673_XMLParser_A01 {
    private SecurityManager securityManager;

    public java_11673_XMLParser_A01() {
        securityManager = System.getSecurityManager();
    }

    public void parse(String xml) {
        if (securityManager != null) {
            Permission permission = new Permission("readElement");
            securityManager.setClassPrivileges("java.io.File", "createFiles", permission);
        }

        // Create a new reader
        securityManager.doPrivileged(new PrivilegedAction<StringReader>() {
            public StringReader run() {
                return new StringReader(xml);
            }
        });

        // Parse the XML
        // ...
    }
}