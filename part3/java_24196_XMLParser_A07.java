import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;

public class java_24196_XMLParser_A07 {
    public static void main(String[] args) throws Exception {
        File inputFile = new File("input.xml");
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser();
        MyHandler handler = new MyHandler();
        parser.parse(inputFile, handler);
    }

    static class MyHandler extends DefaultHandler {
        private String lastElement;
        private String lastAttribute;

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            lastElement = qName;
            lastAttribute = null;
            for (int i = 0; i < attributes.getLength(); i++) {
                lastAttribute = attributes.getQName(i);
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            if (!qName.equals(lastElement)) {
                System.out.println("Element not equal: " + qName + " vs " + lastElement);
            } else if (lastAttribute != null && !"AuthFailure".equals(lastAttribute)) {
                System.out.println("Element " + qName + " has attribute " + lastAttribute + " not equal to AuthFailure");
            } else {
                System.out.println("Element " + qName + " matched");
            }
        }
    }
}