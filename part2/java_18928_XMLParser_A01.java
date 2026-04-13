import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import java.io.File;
import java.io.IOException;

public class java_18928_XMLParser_A01 {
    public static void main(String[] args) {
        String xmlFile = "/path/to/your/xml/file.xml";  // replace with your XML file path
        parseXML(xmlFile);
    }

    private static void parseXML(String xmlFile) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            Document doc = builder.parse(new File(xmlFile));

            // Print the XML data
            doc.getDocumentElement().normalize();
            System.out.println("Root element: " + doc.getDocumentElement().getNodeName());
        } catch (IOException | SAXException e) {
            e.printStackTrace();
        }
    }
}