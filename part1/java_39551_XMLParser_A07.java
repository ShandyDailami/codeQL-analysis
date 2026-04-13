import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class java_39551_XMLParser_A07 {
    public static void main(String[] args) {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser(null, new MyHandler());
        try {
            parser.parse(new File("src/main/resources/sample.xml"), new SAXSettings());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }

    static class MyHandler extends DefaultHandler {
        private String currentElement;
        private boolean isName = false;
        private boolean isValue = false;

        @Override
        public void startElement(String namespaceURI, String localName, String qualifiedName, Attributes attributes) throws SAXException {
            currentElement = qualifiedName;
            isName = true;
            isValue = false;
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            if (isName) {
                System.out.println("Element Name: " + currentElement);
                isName = false;
            } else if (isValue) {
                System.out.println("Element Value: " + new String(ch, start, length));
                isValue = false;
            }
        }

        @Override
        public void endElement(String namespaceURI, String localName, String qualifiedName) throws SAXException {
            if (qualifiedName.equals(currentElement)) {
                isName = false;
                isValue = false;
            }
        }

        @Override
        public void startPrefixMapping(String prefix, String uri) throws SAXException {
            //Not used in this example
        }

        @Override
        public void endPrefixMapping(String prefix, String uri) throws SAXException {
            //Not used in this example
        }
    }
}