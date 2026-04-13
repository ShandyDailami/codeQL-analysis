import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;

public class java_15984_XMLParser_A08 {

    public static void main(String[] args) {
        File xmlFile = new File("malicious.xml");
        parseXML(xmlFile);
    }

    public static void parseXML(File xmlFile) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        Document document = null;
        try {
            document = builder.parse(xmlFile);
        } catch (SAXException | IOException e) {
            e.printStackTrace();
        }

        // Here we are parsing and trying to parse the XML file again using SAX parser
        // SAX parser is not recommended for security sensitive operations
        // Instead, we should use DOM parser and validate XML data before parsing
        parseXMLUsingDom(document);
    }

    public static void parseXMLUsingDom(Document document) {
        try {
            // Here we are serializing the parsed document back to a file
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(document);
            StreamResult result = new StreamResult(new File("parsed.xml"));
            transformer.transform(source, result);
        } catch (TransformerException e) {
            e.printStackTrace();
        }
    }
}