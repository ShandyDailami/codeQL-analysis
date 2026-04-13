import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import java.io.File;
import java.io.IOException;

public class java_24178_XMLParser_A01 {
    public static void main(String[] args) {
        String fileName = "broken-access-control.xml";
        File file = new File(fileName);
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(file);
            // Now we can safely manipulate the document without any security issues.

            // For example, let's access an element by its ID.
            String id = doc.getElementsByTagName("id").item(0).getTextContent();
            System.out.println("Access granted for id: " + id);

            // Let's add a new element.
            doc.getElementsByTagName("tags").item(0).appendChild(doc.createElement("new_tag"));
            doc.getElementsByTagName("id").item(0).appendChild(doc.createTextNode("new_id"));

            // Let's remove an element.
            doc.getElementsByTagName("id").item(0).getParentNode().removeChild(doc.getElementsByTagName("id").item(0));
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
    }
}