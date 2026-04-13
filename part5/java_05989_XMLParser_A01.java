import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.XMLReader;
import org.xml.sax.XMLReaderFactory;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class java_05989_XMLParser_A01 {

    public static class SecureHandler extends DefaultHandler {
        @Override
        public void startElement(String uri, String localName, String qName,
                                 javax.xml.parsers.Attributes attributes) throws SAXException {
            // Place your security-sensitive operations here.
            // For example, we are printing the element name and attributes.
            System.out.println("Start Element: " + qName);
            for(int i = 0; i < attributes.getLength(); i++) {
                System.out.println("Attribute: " + attributes.getQName(i) + " = " + attributes.getValue(i));
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            // Place your security-sensitive operations here.
            // For example, we are printing the element name.
            System.out.println("End Element: " + qName);
        }
    }

    public static void main(String[] args) {
        try {
            SAXParserFactory saxFactory = SAXParserFactory.newInstance();
            SAXParser saxParser = saxFactory.newSAXParser(new DefaultHandler());

            File inputFile = new File("input.xml");
            XMLReader xmlReader = XMLReaderFactory.newInstance().createXMLReader(new SecureHandler());

            saxParser.parse(inputFile, xmlReader);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }
}