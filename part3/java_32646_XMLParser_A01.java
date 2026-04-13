import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import java.io.File;
import java.io.IOException;

public class java_32646_XMLParser_A01 {

    public static void main(String[] args) {
        File xmlFile = new File("path_to_your_file.xml");
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setValidating(true); // Enable validation
        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(xmlFile);
            // Now you can parse the XML document safely and without any potential security issues
            // For example, you can access and print the XML content:
            System.out.println("XML Content: " + doc.getDocumentElement().getTextContent());
        } catch (IOException | SAXException e) {
            e.printStackTrace();
        }
    }
}