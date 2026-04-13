import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.XMLReader;
import org.xml.sax.SAXParserFactory;
import org.xml.sax.XMLReader;
import java.io.File;
import java.io.IOException;

public class java_04196_XMLParser_A03 {

    public static void main(String[] args) {
        String xmlFilePath = "path/to/your/xml/file.xml";
        parseXMLFile(xmlFilePath);
    }

    private static void parseXMLFile(String xmlFilePath) {
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        try {
            XMLReader xmlReader = saxParserFactory.newSAXParser().getXMLReader();
            xmlReader.setContentHandler(new MyContentHandler());
            xmlReader.parse(new File(xmlFilePath));
        } catch (SAXException | IOException e) {
            e.printStackTrace();
        }
    }

    private static class MyContentHandler extends DefaultHandler {
        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) {
            // This method is called when the start of a new element is found.
            // Do not use external frameworks for security-sensitive operations like injection.
            System.out.println("Start element: " + qName);
        }

        @Override
        public void endElement(String uri, String localName, String qName) {
            // This method is called when the end of a element is found.
            // Do not use external frameworks for security-sensitive operations like injection.
            System.out.println("End element: " + qName);
        }

        @Override
        public void characters(char[] ch, int start, int length) {
            // This method is called when characters are found.
            // Do not use external frameworks for security-sensitive operations like injection.
            String str = new String(ch, start, length);
            System.out.println("Characters: " + str);
        }
    }
}