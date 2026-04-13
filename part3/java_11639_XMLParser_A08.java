import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class java_11639_XMLParser_A08 {
    public static void main(String[] args) {
        try {
            // Load the XML file
            InputStream inputStream = new FileInputStream(new File("input.xml"));

            // Get the DocumentBuilderFactory instance
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

            // Get the DocumentBuilder instance
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Parse the content of the XML file into a Document object
            Document document = builder.parse(inputStream);

            // Print the document
            document.getDocumentElement().getFirstChild().normalize();
            System.out.println(document.getElements().getItem(0).getNodeName());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}