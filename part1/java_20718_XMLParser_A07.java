import java.io.File;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.helpers.SAXHelper;

public class java_20718_XMLParser_A07 {
    private class MyHandler extends DefaultHandler {
        public void startDocument() {
            // Do nothing, this is a placeholder
        }
        public void endDocument() {
            // Do nothing, this is a placeholder
        }
        public void startElement(String uri, String localName, String qName) {
            // Do nothing, this is a placeholder
        }
        public void endElement(String uri, String localName, String qName) {
            // Do nothing, this is a placeholder
        }
        public void characters(char[] ch, int start, int length) {
            // Do nothing, this is a placeholder
        }
        public void fatalError(SAXException e) {
            System.out.println("Fatal Error: " + e.getMessage());
        }
        public void warning(SAXWarning e) {
            System.out.println("Warning: " + e.getMessage());
        }
    }

    public void parse(String fileName) {
        File inputFile = new File(fileName);
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(inputFile);

        SAXHelper saxHelper = new SAXHelper(new MyHandler(), doc);
        XMLReader xr = saxHelper.getXMLReader();

        xr.setContentHandler(new MyHandler());
        xr.setErrorHandler(new MyHandler());

        xr.parse("");
    }

    public static void main(String[] args) {
        SecureXMLParser parser = new SecureXMLParser();
        parser.parse("yourfile.xml");
    }
}