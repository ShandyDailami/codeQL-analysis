import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.helpers.DefaultHandler;
import java.io.File;
import java.io.IOException;

public class java_40818_XMLParser_A08 {

    public static void main(String[] args) {
        String xmlFilePath = "/path/to/your/xml/file.xml";  // replace with your xml file path
        parseXmlFile(xmlFilePath);
    }

    private static void parseXmlFile(String xmlFilePath) {
        File xmlFile = new File(xmlFilePath);
        DefaultHandler handler = new DefaultHandler() {
            boolean isInElement = false;

            public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
                isInElement = true;
                System.out.println("Start element: " + qName);
            }

            public void endElement(String uri, String localName, String qName) throws SAXException {
                isInElement = false;
                System.out.println("End element: " + qName);
            }

            public void characters(char[] ch, int start, int length) throws SAXException {
                if (isInElement) {
                    System.out.println("Character data: " + new String(ch, start, length));
                }
            }
        };

        try {
            SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
            SAXParser saxParser = saxParserFactory.newSAXParser(handler);
            XMLReader xmlReader = XMLReaderFactory.createXMLReader();
            xmlReader.setContentHandler(handler);
            xmlReader.parse(xmlFile);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }
}