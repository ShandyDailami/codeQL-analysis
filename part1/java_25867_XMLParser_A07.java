import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;

public class java_25867_XMLParser_A07 {

    public static void main(String[] args) {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        try {
            SAXParser parser = factory.newSAXParser(null, new XMLHandler());
            parser.parse(new File("yourfile.xml"), false);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static class XMLHandler extends DefaultHandler {
        boolean bElementName = false;
        boolean bElementValue = false;

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            if (qName.equalsIgnoreCase("element")) {
                bElementName = true;
            } else if (bElementName) {
                bElementValue = true;
                System.out.println("Element Name: " + qName);
                bElementName = false;
            }
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            if (bElementValue) {
                String value = new String(ch, start, length);
                System.out.println("Element Value: " + value);
                bElementValue = false;
            }
        }
    }
}