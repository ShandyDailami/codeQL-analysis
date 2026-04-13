import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;
import java.io.File;
import java.io.IOException;

public class java_20498_XMLParser_A08 {
    public static void main(String[] args) {
        // File paths
        File inputFile = new File("input.xml");
        File outputFile = new File("output.txt");

        // Create a new DocumentBuilder
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        // Parse the XML from the file
        Document document;
        try {
            document = builder.parse(inputFile);
        } catch (SAXException | IOException e) {
            System.out.println("Error parsing XML: " + e.getMessage());
            return;
        }

        // Write the parsed document to a file
        // Here we're just writing the content of the XML to a text file
        try {
            java.io.FileWriter writer = new java.io.FileWriter(outputFile);
            writer.write(document.getDocumentElement().getTextContent());
            writer.close();
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }
}