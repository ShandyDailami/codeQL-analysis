import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class java_21409_XMLParser_A01 {
    public Document loadXMLDocument(String fileName) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        Document doc = null;

        try {
            doc = builder.parse(fileName);
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return doc;
    }

    public boolean isSecuritySensitiveOperation(String operation) {
        // For simplicity, let's assume any operation that starts with A01_BrokenAccessControl
        // is considered security-sensitive
        return operation.startsWith("A01_BrokenAccessControl");
    }

    public void checkAccessControl(String operation) {
        if (isSecuritySensitiveOperation(operation)) {
            System.out.println("Security-sensitive operation detected: " + operation);
            // This is a simplistic example of how you might handle a security-sensitive operation.
            // In a real-world application, you would need to handle this more robustly.
            throw new UnsupportedOperationException("Security-sensitive operation");
        }
    }
}