import java.io.File;
import java.io.FileInputStream;
import java.security.AccessControlException;
import java.security.AccessController;
import java.security.PrivilegedAction;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class java_33231_XMLParser_A01 {

    public static void main(String[] args) {

        File inputFile = new File("input.xml");
        FileInputStream fis = null;
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        try {
            fis = new FileInputStream(inputFile);
            Document doc = builder.parse(fis);
            // No exception will be thrown for a secure operation.
            System.out.println("XML file parsed successfully.");
        } catch (AccessControlException e) {
            System.out.println("Access denied for file: " + inputFile.getName());
        } catch (SAXException e) {
            System.out.println("Error in XML file: " + inputFile.getName());
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    System.out.println("Error closing file: " + inputFile.getName());
                }
            }
        }
    }
}