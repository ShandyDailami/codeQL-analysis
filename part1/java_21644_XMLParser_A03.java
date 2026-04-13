import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class java_21644_XMLParser_A03 {

    public static class ProductHandler implements org.xml.sax.helpers.DefaultHandler {
        private boolean bName = false;
        private boolean bPrice = false;
        private String name = null;
        private String price = null;

        public void startElement(String uri, String localName, String qName)
                throws SAXException {
            if (qName.equalsIgnoreCase("Name")) {
                bName = true;
            } else if (qName.equalsIgnoreCase("Price")) {
                bPrice = true;
            }
        }

        public void characters(char[] ch, int start, int length)
                throws SAXException {
            if (bName) {
                name = new String(ch, start, length);
                bName = false;
            } else if (bPrice) {
                price = new String(ch, start, length);
                bPrice = false;
            }
        }

        public void endElement(String uri, String localName, String qName)
                throws SAXException {
            if (qName.equalsIgnoreCase("Product")) {
                System.out.println("Name: " + name + ", Price: " + price);
            }
        }
    }

    public static void main(String[] args) {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        try {
            SAXParser parser = factory.newSAXParser();
            XMLReader reader = XMLReaderFactory.createXMLReader();
            ProductHandler handler = new ProductHandler();
            reader.setContentHandler(handler);
            File inputFile = new File("products.xml");
            reader.parse(inputFile);
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}