import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class java_29398_XMLParser_A01 {
    public static void main(String[] args) {
        String xmlFilePath = "path_to_your_xml_file";
        File xmlFile = new File(xmlFilePath);

        // Check if file exists
        if (!xmlFile.exists()) {
            System.out.println("File not found!");
            return;
        }

        try {
            // Create DocumentBuilderFactory
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

            // Create a DocumentBuilder
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Parse the XML file
            Document doc = builder.parse(xmlFile);

            // Print the XML content
            System.out.println(doc.getDocumentElement().getNodeName());

        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
    }
}