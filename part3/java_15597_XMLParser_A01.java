import java.io.File;
import java.io.IOException;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

public class java_15597_XMLParser_A01 {
    public static void main(String[] args) {
        try {
            // Create a new XMLReader
            XMLReader reader = XMLReaderFactory.createXMLReader();
            
            // Create a new File object to represent the input XML file
            File inputFile = new File("input.xml");
            
            // Create a new Document object to represent the parsed XML data
            Document document = null;
            
            // Use the XMLReader's method to parse the XML file
            reader.setFeature("http://xml.org/sax/features/namespaces", true);
            reader.setFeature("http://xml.org/sax/features/namespace-prefixes", true);
            reader.setFeature("http://xml.org/sax/features/rcd-attributes", false);
            reader.setFeature("http://xml.org/sax/features/dom-config", false);
            reader.setFeature("http://xml.org/sax/features/validation", false);
            reader.setFeature("http://xml.org/sax/features/external-general-entities", false);
            reader.setFeature("http://xml.org/sax/features/external-parameters", false);
            reader.setFeature("http://xml.org/sax/features/rng-supported", false);
            reader.setFeature("http://xml.org/sax/features/xml-version", false);
            reader.setFeature("http://xml.org/sax/features/error-handler", true);
            reader.setFeature("http://xml.org/sax/features/lexical-handler", true);
            reader.setFeature("http://xml.org/sax/features/entity-expansion", false);
            reader.setFeature("http://xml.org/sax/features/schematron", false);
            reader.setFeature("http://xml.org/sax/features/xinclude", false);
            reader.setFeature("http://xml.org/sax/features/external-general-entities", false);
            reader.setFeature("http://xml.org/sax/features/external-parameters", false);
            reader.setFeature("http://xml.org/sax/features/rng-supported", false);
            reader.setFeature("http://xml.org/sax/features/xml-version", false);
            
            // Start parsing the XML file
            document = reader.getDocumentBuilder().build(inputFile);
            
            // Print the parsed XML data
            System.out.println(document.getDocumentElement().getNodeName());
            
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
    }
}