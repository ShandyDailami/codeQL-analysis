import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;
import javax.xml.transform.stream.StreamSource;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import java.io.File;
import java.io.IOException;

public class java_34150_XMLParser_A01 {
    public static void main(String[] args) {
        try {
            parseXML("example.xml");
        } catch (SAXException | IOException | TransformerException e) {
            e.printStackTrace();
        }
    }

    public static void parseXML(String fileName) throws SAXException, IOException, TransformerException {
        // Create a factory for the parser
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

        // Create a builder
        DocumentBuilder builder = factory.newDocumentBuilder();

        // Create a new document
        Document doc = builder.parse(new File(fileName));

        // Create a transformer
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();

        // Create an output file
        StreamResult result = new StreamResult("output_parsed.xml");

        // Use the transformer to write the parsed data into a file
        transformer.transform(new StreamSource(new File(fileName)), result);
    }
}