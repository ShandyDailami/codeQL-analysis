import java.io.File;
import java.io.IOException;
import java.security.AccessControlException;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;

public class java_15454_XMLParser_A01 {

    public static void main(String[] args) {
        try {
            XmlParserExample example = new XmlParserExample();
            example.parseXml("example.xml");
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void parseXml(String fileName) throws IOException, SAXException, ParserConfigurationException {
        // Create the factory
        javax.xml.parsers.XMLParserFactory factory = XMLParserFactory.newInstance();

        // Create the parser
        XMLParser parser = factory.newParser();

        // Set the input file
        parser.setInput(new File(fileName));

        // Start processing XML document
        parser.parse();

        // TODO: You can perform security-sensitive operations here, e.g.,
        // check if the XML document is broken, access control, etc.
    }
}