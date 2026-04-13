import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.SAXParseException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.enters.SAXEntry;
import java.io.File;
import java.io.IOException;

public class java_41523_XMLParser_A08 {

    public static void main(String[] args) {
        File inputFile = new File("input.xml");
        SAXParser saxParser = new SAXParser();
        saxParser.parse(inputFile, new DefaultHandler() {
            @Override
            public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
                System.out.println("Element: " + qName);
            }
        });
    }

    public static class SAXParser {

        private SAXReader saxReader;

        public java_41523_XMLParser_A08() {
            saxReader = SAXReaderFactory.newInstance();
        }

        public void parse(File inputFile, DefaultHandler defaultHandler) {
            try {
                XMLReader xmlReader = saxReader.buildXMLReader(defaultHandler);
                xmlReader.parse(inputFile);
            } catch (IOException e) {
                e.printStackTrace();
            } catch (SAXParseException e) {
                e.printStackTrace();
            } catch (SAXException e) {
                e.printStackTrace();
            }
        }
    }
}