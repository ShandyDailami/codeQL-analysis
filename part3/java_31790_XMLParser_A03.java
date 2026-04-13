import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.XMLReader;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;

public class java_31790_XMLParser_A03 {

    public static void main(String[] args) {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser();

        try {
            XMLReader reader = parser.getXMLReader();
            MyHandler handler = new MyHandler();
            reader.setContentHandler(handler);
            reader.parse(new File("data.xml")); // replace with your file
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static class MyHandler extends DefaultHandler {

        boolean bElementName = false;
        String elementName = null;

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            bElementName = true;
            elementName = qName;
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            bElementName = false;
            if(bElementName) {
                System.out.println("Element Name: " + elementName);
                elementName = null;
            }
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            if(bElementName) {
                System.out.println("Element Content: " + new String(ch, start, length));
            }
        }
    }
}