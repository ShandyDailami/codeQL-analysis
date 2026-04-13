import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.security.AccessControlException;
import java.security.AccessController;
import java.security.PrivilegedAction;

public class java_17517_XMLParser_A01 {

    public static void main(String[] args) {

        try {
            AccessController.doPrivileged(new PrivilegedAction<Void>() {
                public Void run() {
                    InputStream in = new FileInputStream("securityTest.xml");
                    XMLParser(in);
                    return null;
                }
            });

        } catch (FileNotFoundException e) {
            System.out.println("The file securityTest.xml not found, please check the path.");
        } catch (AccessControlException e) {
            System.out.println("Access to file securityTest.xml is denied by the application.");
        }
    }

    private static void XMLParser(InputStream inputStream) {

        System.out.println("Parsing XML file using Java...");

        // ... parse the XML here ...

        System.out.println("XML Parsing Completed!");
    }
}