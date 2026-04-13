import java.io.File;
import java.io.IOException;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

public class java_02318_XMLParser_A03 {

    public static void main(String[] args) {
        // Creating XMLReader instance
        XMLReader xmlReader;

        // Using SAX parser
        xmlReader = XMLReaderFactory.createXMLReader();

        // Creating a File object to point to the XML file
        File xmlFile = new File("sample.xml");

        // Using a custom SAXHandler
        SAXHandler saxHandler = new SAXHandler();

        // Parsing the XML file
        try {
            xmlReader.setContentHandler(saxHandler);
            xmlReader.parse(xmlFile);

        } catch (SAXException e) {
            e.printStackTrace();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class SAXHandler implements org.xml.sax.helpers.DefaultHandler {

    @Override
    public void startDocument() throws SAXException {
        System.out.println("Start of Document");
    }

    @Override
    public void endDocument() throws SAXException {
        System.out.println("End of Document");
    }

    @Override
    public void startElement(String uri, String localName, String qualifiedName, org.xml.sax.Attributes attributes) throws SAXException {
        System.out.println("Start of Element: " + localName);
    }

    @Override
    public void endElement(String uri, String localName, String qualifiedName) throws SAXException {
        System.out.println("End of Element: " + localName);
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        String contents = new String(ch, start, length);
        System.out.println("Characters: " + contents);
    }

    @Override
    public void warning(SAXException e) {
        System.out.println("Warning: " + e.getMessage());
    }

    @Override
    public void error(SAXException e) {
        System.out.println("Error: " + e.getMessage());
    }

    @Override
    public void fatalError(SAXException e) {
        System.out.println("Fatal Error: " + e.getMessage());
    }
}