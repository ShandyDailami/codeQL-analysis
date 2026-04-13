import java.io.FileInputStream;
import java.io.InputStream;
import java.io.IOException;
import java.security.ProtectionDomain;
import java.security.CodeSource;
import java.security.Permission;
import java.security.SecurityManager;
import java.security.PrivilegedAction;

public class java_08684_XMLParser_A01 {

    public static void main(String[] args) {

        String xmlFilePath = "/path/to/your/xml/file";

        // Check the security manager to see if it allows us to load the file
        SecurityManager sm = System.getSecurityManager();
        if (sm != null) {
            sm.checkLoadClass(XmlParser.class.getClassLoader(), "file:/" + xmlFilePath);
        }

        parseXmlFile(xmlFilePath);
    }

    private static void parseXmlFile(String xmlFilePath) {
        ClassLoader cl = XmlParser.class.getClassLoader();

        ProtectionDomain pd = java.security.Security.getAccessControl(cl).new ProtectionDomain(XmlParser.class.getClassLoader(), "");

        PrivilegedAction<?> pa = new PrivilegedAction<Void>() {
            public Void run() {
                try {
                    InputStream is = cl.getResourceAsStream(xmlFilePath);
                    if (is == null) {
                        System.out.println("Resource not found: " + xmlFilePath);
                    } else {
                        java.util.Scanner s = new java.util.Scanner(is).useDelimiter("\\A");
                        while (s.hasNext()) {
                            System.out.println(s.next());
                        }
                        s.close();
                    }
                    return null;
                } catch (IOException ex) {
                    System.out.println(ex.getMessage());
                    return null;
                }
            }
        };
        java.security.AccessControl daAC = java.security.AccessControl
                .getAccess(new ProtectionDomain[] { pd },
                        new java.security.PrivilegedAction<java.security.CodeSource>() {
                            public java.security.CodeSource get() {
                                CodeSource cs = XmlParser.class.getProtectionDomain().getCodeSource();
                                if (cs == null)
                                    throw new AssertionError();
                                return cs;
                            }
                        });

        daAC.checkPermission(new Permission[] { new java.io.FilePermission("file:/" + xmlFilePath, "read") });

        try {
            pa.run();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}