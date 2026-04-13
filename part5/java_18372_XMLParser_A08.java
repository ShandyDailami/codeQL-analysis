import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.events.DefaultHandler;
import java.io.File;
import java.io.IOException;

public class java_18372_XMLParser_A08 {

    public static void main(String[] args) {
        String xmlFilePath = "/path/to/your/xml/file.xml";  // Replace with your actual XML file path

        // Parse XML file using SAX
        parseXmlFile(xmlFilePath);
    }

    private static void parseXmlFile(String xmlFilePath) {
        File xmlFile = new File(xmlFilePath);

        // Create a SAX parser
        XMLReader xmlReader = createSaxParser();

        // Set the XML file as the source of the SAX parser
        try {
            xmlReader.setInputFile(xmlFile.getAbsolutePath());
        } catch (SAXException e) {
            e.printStackTrace();
            return;
        }

        // Process the SAX events
        DefaultHandler defaultHandler = new DefaultHandler() {
            @Override
            public void startDocument() {
                System.out.println("Start of XML document");
            }

            @Override
            public void endDocument() {
                System.out.println("End of XML document");
            }

            @Override
            public void startElement(String uri, String localName, String qName) {
                System.out.println("Start of element: " + qName);
            }

            @Override
            public void endElement(String uri, String localName, String qName) {
                System.out.println("End of element: " + qName);
            }

            @Override
            public void characters(char[] ch, int start, int length) {
                String value = new String(ch, start, length);
                System.out.println("Character data: " + value);
            }

            @Override
            public void fatalError(SAXException e) {
                System.out.println("Fatal Error: " + e.getMessage());
            }

            @Override
            public void warning(SAXException e) {
                System.out.println("Warning: " + e.getMessage());
            }
        };

        try {
            xmlReader.setContentHandler(defaultHandler);
            xmlReader.parseXIncludeSecurity();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }

    private static XMLReader createSaxParser() {
        XMLReader xmlReader = null;

        try {
            xmlReader = XMLReaderFactory.createXMLReader();
        } catch (SAXException e) {
            e.printStackTrace();
        }

        return xmlReader;
    }
}