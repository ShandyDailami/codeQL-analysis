import java.io.*;
import java.security.AccessControlException;
import java.security.AccessController;
import java.security.PrivilegedAction;

public class java_38739_XMLParser_A01 {

    public static void main(String[] args) {
        try {
            AccessController.doPrivileged(new PrivilegedAction<Void>() {
                public Void run() {
                    readFileWithAccessControl();
                    return null;
                }
            });
        } catch (Exception e) {
            System.out.println("Access Control Exception: " + e.getMessage());
        }
    }

    private static void readFileWithAccessControl() throws IOException {
        File file = new File("path_to_your_xml_file.xml");
        FileReader reader = new FileReader(file);
        try (reader) {
            int c;
            while ((c = reader.read()) != -1) {
                System.out.print((char) c);
            }
        }
    }
}