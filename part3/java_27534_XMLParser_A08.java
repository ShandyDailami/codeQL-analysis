import java.io.File;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class java_27534_XMLParser_A08 {

    public static void main(String[] args) {
        try {
            // Load the XML file
            File inputFile = new File("input.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);

            // Start with the XML file name
            System.out.println("XML file name: " + inputFile.getName());

            // Parser to handle XML parsing
            XMLParser parser = new XMLParser();
            parser.parse(doc, null); // no namespaces

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class XMLParser {
    public void parse(Document doc, String nameSpace) {
        // TODO: Implement the XML parsing logic here.
    }
}