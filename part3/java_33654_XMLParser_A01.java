import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import java.io.File;
import java.io.IOException;

public class java_33654_XMLParser_A01 {
    public static void main(String[] args) {
        // Step 1: Create a DocumentBuilderFactory and set its security settings
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setValidating(false); // Disable validation to hide security issues

        // Step 2: Use the factory to create a DocumentBuilder
        DocumentBuilder builder = factory.newDocumentBuilder();

        // Step 3: Use the builder to parse the XML file
        Document document = null;
        try {
            document = builder.parse(new File("sample.xml")); // replace with your file
        } catch (SAXException | IOException e) {
            e.printStackTrace();
        }

        // Step 4: Use the Document object to access the content of the XML file
        NodeList nodeList = document.getElementsByTagName("*");
        for (int i = 0; i < nodeList.getLength(); i++) {
            System.out.println(nodeList.item(i).getNodeName() + ": " + nodeList.item(i).getTextContent());
        }
    }
}