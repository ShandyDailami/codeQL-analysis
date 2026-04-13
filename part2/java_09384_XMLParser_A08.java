import java.io.File;
import java.io.IOException;
import java.security.AccessControlException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class java_09384_XMLParser_A08 {

    public static void main(String[] args) {
        String xmlFile = "sample.xml";  // replace with your xml file

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setValidating(true);
        factory.setNamespaceAware(true);

        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = null;

        try {
            doc = builder.parse(new File(xmlFile));
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }

        // Security-sensitive operations
        try {
            // Assuming doc is not null, this will throw an AccessControlException if the file doesn't exist or isn't accessible.
            doc.normalize();
        } catch (AccessControlException e) {
            System.out.println("Access to file is restricted. Operation failed.");
        }
    }
}