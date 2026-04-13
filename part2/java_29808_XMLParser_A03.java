import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class java_29808_XMLParser_A03 {
    public static void main(String[] args) {
        String filePath = "/path/to/your/xml/file.xml";
        File xmlFile = new File(filePath);
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document;

        try {
            document = builder.parse(xmlFile);

            // Check if the file has been tampered with
            // This is a simple example, and a real-world application would require a more sophisticated check
            if (document.hasModified()) {
                System.out.println("The XML file has been tampered with, and the program is exiting.");
                System.exit(0);
            }

            System.out.println("The XML file is secure.");

        } catch (SAXException | IOException e) {
            System.out.println("Error parsing XML file: " + e.getMessage());
       
        }
    }
}