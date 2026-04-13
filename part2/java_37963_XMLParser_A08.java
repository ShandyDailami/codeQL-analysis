import javax.xml.parsers.*;
import org.xml.sax.*;
import java.io.*;

public class java_37963_XMLParser_A08 {
    public static void main(String[] args) {
        try {
            // Create an instance of the XMLReader
            XMLReader xr = XMLReaderFactory.createXMLReader();

            // Create an instance of the SAXHandler
            SAXHandler sh = new SAXHandler();
            xr.setContentHandler(sh);

            // Parse the XML document
            xr.parse("src/main/resources/A08_IntegrityFailure.xml");
        } catch (FileNotFoundException e) {
            System.out.println("Error: The file was not found");
        } catch (ParserConfigurationException e) {
            System.out.println("Error: Parser configuration failed");
        } catch (SAXException e) {
            System.out.println("Error: SAX parsing failed");
        }
    }
}

class SAXHandler implements SAXHandlerInterface {
    private boolean integrityFailureFound = false;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName.equals("IntegrityFailure")) {
            integrityFailureFound = true;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        // do nothing
    }

    @Override
    public void characters(String text) throws SAXException {
        // do nothing
    }

    public boolean isIntegrityFailureFound() {
        return integrityFailureFound;
    }
}

interface SAXHandlerInterface extends ContentHandler, DTDHandler, EntityResolver {
    // define the methods of SAXHandlerInterface
}