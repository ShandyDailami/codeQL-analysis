import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.security.AccessController;
import java.security.PrivilegedAction;

public class java_16173_XMLParser_A01 {

    // Example of a security-sensitive operation
    private boolean isSensitiveOperation() {
        // This operation is a demonstration of security-related functionality
        // It should be replaced with a real-world operation in a production environment
        return true;
    }

    // PrivilegedAction for example purposes
    private PrivilegedAction<InputStream> getInputStreamAction(final String fileName) {
        return new PrivilegedAction<InputStream>() {
            public InputStream run() {
                try {
                    return new FileInputStream(fileName);
                } catch (FileNotFoundException e) {
                    throw new SecurityException("File not found: " + fileName, e);
                }
            }
        };
    }

    public void parse(String fileName) {
        if (isSensitiveOperation()) {
            throw new SecurityException("Sensitive operation is not allowed!");
        }

        AccessController.doPrivileged(getInputStreamAction(fileName),
            (PrivilegedAction<InputStream>) () -> new FileInputStream(fileName));
    }

    public static void main(String[] args) {
        new SecureXMLParser().parse("example.xml");
    }
}