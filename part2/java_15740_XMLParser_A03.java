import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class java_15740_XMLParser_A03 {
    public static void main(String[] args) {
        File xmlFile = new File("path_to_your_file.xml");
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(xmlFile);

            // Parsing and printing the XML data
            parseAndPrint(document);

        } catch (IOException | SAXException e) {
            e.printStackTrace();
        }
    }

    private static void parseAndPrint(Document document) {
        // Parsing and printing the XML data
        // This is a placeholder and won't actually print anything because we're just parsing the document
        System.out.println("Parsed XML Data: " + document.getDocumentElement().getNodeName());
    }
}