import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.SAXParserFactory;
import org.xml.sax.XMLReader;
import org.xml.sax.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;

public class java_12257_XMLParser_A01 {

    public static void main(String[] args) {
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser(false);

            XMLReader reader = saxParser.getXMLReader();
            MyHandler handler = new MyHandler();
            reader.setContentHandler(handler);

            File xmlFile = new File("example.xml");
            reader.parse(xmlFile);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static class MyHandler extends DefaultHandler {

        boolean bName = false;
        boolean bAge = false;

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            if (qName.equalsIgnoreCase("Person")) {
                bName = true;
                bAge = true;
                System.out.println("Name and Age found!");
                return;
            }

            if (bName) {
                System.out.println("Name: " + localName);
                bName = false;
            }

            if (bAge) {
                System.out.println("Age: " + localName);
                bAge = false;
            }
        }
    }
}