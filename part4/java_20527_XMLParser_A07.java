import java.io.FileInputStream;
import java.io.InputStream;
import java.security.AccessControlException;
import java.util.List;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.parser.XMLParser;
import org.xml.sax.parser.XMLReader;
import org.xml.sax.parser.XSAFException;

public class java_20527_XMLParser_A07 {
    public static void main(String[] args) {
        try {
            XMLReader parser = XMLParser.getSAXParser();
            SAXHandler handler = new SAXHandler();
            parser.setContentHandler(handler);

            InputStream input = new FileInputStream("sample.xml");
            parser.parse(input);
            input.close();

            List<String> elements = handler.getElements();
            for (String element : elements) {
                System.out.println(element);
            }
        } catch (XSAFException e) {
            System.out.println("XML Parsing Failed: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    static class SAXHandler extends DefaultHandler {
        private List<String> elements;
        private String currentElement;
        private int currentDepth;

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            currentElement = qName;
            currentDepth++;
            elements.add(currentElement);
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            currentElement = qName;
            currentDepth--;
            elements.add(currentElement);
        }

        public List<String> getElements() {
            return elements;
        }
    }
}