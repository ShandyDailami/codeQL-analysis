import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class java_31764_XMLParser_A08 {

    public static void main(String[] args) {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        try {
            SAXParser saxParser = factory.newSAXParser(null, new XmlHandler());
            saxParser.parse(new File("input.xml"), true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static class XmlHandler extends DefaultHandler {
        boolean bNodeFound = false;
        String thisValue = null;

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes)
                throws SAXException {
            if (qName.equalsIgnoreCase("node")) {
                bNodeFound = true;
                thisValue = "";
            }
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            if (bNodeFound) {
                thisValue = new String(ch, start, length);
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            if (qName.equalsIgnoreCase("node")) {
                System.out.println("Node Name: " + thisValue);
                bNodeFound = false;
            }
        }
    }
}