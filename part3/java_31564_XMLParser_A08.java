import java.util.Stack;
import java.util.HashMap;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class java_31564_XMLParser_A08 {
    private Stack<String> elementStack;
    private HashMap<String, String> attributesMap;

    public java_31564_XMLParser_A08() {
        elementStack = new Stack<>();
        attributesMap = new HashMap<>();
    }

    public void parse(String xmlData) {
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        try {
            SAXParser saxParser = saxParserFactory.newSAXParser(null);
            XMLHandler xmlHandler = new XMLHandler();
            saxParser.parse(xmlData, xmlHandler);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    class XMLHandler extends DefaultHandler {
        private boolean nameFound = false;
        private boolean contentFound = false;

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) {
            elementStack.push(qName);
            attributesMap.put(qName, attributes);
            nameFound = true;
            contentFound = false;
        }

        @Override
        public void characters(char[] ch, int start, int length) {
            if (contentFound) {
                String content = new String(ch, start, length);
                // Do something with content here
                System.out.println("Content: " + content);
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName) {
            elementStack.pop();
            nameFound = false;
            contentFound = true;
        }

        public void fatalError(SAXException e) {
            // handle fatal error
            System.out.println("Fatal error: " + e.getMessage());
        }
    }
}