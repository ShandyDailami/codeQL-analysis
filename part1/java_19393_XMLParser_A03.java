import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class java_19393_XMLParser_A03 {

    public static void main(String[] args) {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        try {
            SAXParser parser = factory.newSAXParser(null, new XmlHandler());
            parser.parse(new File("data.xml"), true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static class XmlHandler extends DefaultHandler {
        boolean bName = false;
        boolean bValue = false;
        String strName = "";
        String strValue = "";

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            if (qName.equalsIgnoreCase("name")) {
                bName = true;
            } else if (qName.equalsIgnoreCase("value")) {
                bValue = true;
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            if (qName.equalsIgnoreCase("name")) {
                bName = false;
            } else if (qName.equalsIgnoreCase("value")) {
                bValue = false;
            }
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            if (bName) {
                strName = new String(ch, start, length);
            } else if (bValue) {
                strValue = new String(ch, start, length);
            }
        }

        @Override
        public void endDocument() throws SAXException {
            System.out.println("Name : " + strName + ", Value : " + strValue);
        }
    }
}