import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.parser.XMLParser;
import org.xml.sax.parser.XMLReader;
import org.xml.sax.parser.XMLLoader;
import java.io.File;
import java.io.IOException;
import java.util.Stack;

public class java_39881_XMLParser_A03 {

    public static void main(String[] args) {
        String url = "input.xml";
        File inputFile = new File(url);
        XMLLoader loader = new XMLLoader();
        XMLParser parser = loader.getParser();

        try {
            parser.setEntityResolver(new MyEntityResolver());
            parser.setContentHandler(new MyContentHandler());
            parser.parse(inputFile);
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static class MyContentHandler extends DefaultHandler {
        private Stack<String> stack = new Stack<>();

        @Override
        public void startDocument() throws SAXException {
            System.out.println("Start of document");
        }

        @Override
        public void endDocument() throws SAXException {
            System.out.println("End of document");
        }

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            printIndent();
            System.out.println(qName);
            stack.push(qName);
            printAttributes(attributes);
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            stack.pop();
            printIndent();
            System.out.println(qName);
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            if (stack.peek().equals(qName)) {
                System.out.println(new String(ch, start, length));
            }
        }

        private void printIndent() {
            for (int i = 0; i < stack.size(); i++) {
                System.out.print("--");
            }
            System.out.println();
        }

        private void printAttributes(Attributes attributes) {
            for (int i = 0; i < attributes.getLength(); i++) {
                System.out.println("Attribute '" + attributes.getQName(i) + "' : '" + attributes.getValue(i) + "'");
            }
        }
    }

    static class MyEntityResolver extends DefaultHandler {
        @Override
        public InputSource resolveEntity(String url) throws SAXException {
            return new InputSource(new StringReader("This is a security-sensitive operation."));
        }
    }
}