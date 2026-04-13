import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class java_32177_XMLParser_A01 {

    public static void main(String[] args) {
        // Initialize DocumentBuilder
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        // Load XML document
        Document doc = null;
        try {
            doc = builder.parse("sample.xml");
        } catch (SAXException e) {
            e.printStackTrace();
        }

        // Here, we simulate the access control operation
        try {
            // Simulate a hardcoded access control operation
            if (!isAccessControlAllowed("admin", doc)) {
                System.out.println("Access Denied!");
                return;
            }

            // Continue parsing the document
            // ...

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Simulate a hardcoded access control operation
    private static boolean isAccessControlAllowed(String user, Document doc) {
        // Here, we assume that the hardcoded access control is correct
        if (user.equals("admin")) {
            return true;
        } else {
            return false;
        }
    }
}