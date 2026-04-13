import javax.xml.parsers.SAXParserFactory;
import javax.xml.parsers.SAXParser;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class java_18912_XMLParser_A03 {

    public static void main(String[] args) {
        SAXParserFactory factory = SAXParserFactory.newInstance();

        try {
            SAXParser parser = factory.newSAXParser(null, new XmlHandler());
            parser.parse(Thread.currentThread().getContextClassLoader().getResourceAsStream("sample.xml"), true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static class XmlHandler extends DefaultHandler {
        boolean bElementName = false;
        boolean bElementValue = false;

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes)
                throws SAXException {
            if (qName.equalsIgnoreCase("element")) {
                bElementName = true;
                bElementValue = false;
            }
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            if (bElementName) {
                bElementName = false;
                System.out.println("Element Value: " + new String(ch, start, length));
            }
            if (bElementValue) {
                bElementValue = false;
                System.out.println("Element Name: " + new String(ch, start, length));
            }
        }
    }
}