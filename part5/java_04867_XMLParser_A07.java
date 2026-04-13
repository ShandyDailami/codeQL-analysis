// importing necessary libraries
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;
import java.io.File;
import java.io.IOException;

public class java_04867_XMLParser_A07 {
    public static void main(String[] args) {
        // create a DocumentBuilderFactory
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();

        try {
            // create a DocumentBuilder
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();

            // parse the XML file
            Document doc = dBuilder.parse(new File("A07_AuthFailure.xml"));

            // parse the document
            // check for security failures here, for example:
            String authFailure = doc.getElementsByTagName("authFailure").item(0).getTextContent();
            if ("FAILURE".equals(authFailure)) {
                System.out.println("Authentication failure detected.");
            } else {
                System.out.println("Authentication successful.");
            }

        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}