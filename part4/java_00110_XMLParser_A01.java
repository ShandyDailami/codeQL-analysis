import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import java.io.File;
import java.io.IOException;

public class java_00110_XMLParser_A01 {
    public static void main(String[] args) {
        try {
            File xmlFile = new File("path_to_your_file.xml"); // replace with your file path

            // Create a DocumentBuilderFactory
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

            // Use factory to create a new DocumentBuilder
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Use builder to parse the file and store the result in the Document object
            Document document = builder.parse(xmlFile);

            // Get the root element of the Document
            Element root = document.getDocumentElement();

            // Print the XML content
            System.out.println("XML Content: " + root.getNodeName());

            // Close the Document
            document.close();
        } catch (IOException | SAXException e) {
            e.printStackTrace();
        }
    }
}