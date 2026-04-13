import java.util.Stack;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class java_27779_XMLParser_A08 {
    public static void main(String[] args) {
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser parser = factory.newSAXParser(null);
            XmlHandler handler = new XmlHandler();
            parser.parse(new InputStreamReader(new FileInputStream("example.xml"), "UTF-8"), handler);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static class XmlHandler extends DefaultHandler {
        private Stack<String> elementStack = new Stack<>();
        private List<String> names = new ArrayList<>();

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) {
            elementStack.push(qName);
            names.add(qName);
        }

        @Override
        public void endElement(String uri, String localName, String qName) {
            elementStack.pop();
        }

        @Override
        public void characters(char[] ch, int start, int length) {
            String str = new String(ch, start, length);
            str = str.trim();
            if (!str.isEmpty()) {
                if (elementStack.peek() != null) {
                    names.add(elementStack.peek() + "=\"" + str + "\"");
                }
            }
        }

        @Override
        public void error(SAXException e) {
            System.out.println("Error: " + e.getMessage());
        }

        @Override
        public void fatalError(SAXException e) {
            System.out.println("Fatal Error: " + e.getMessage());
        }
    }
}