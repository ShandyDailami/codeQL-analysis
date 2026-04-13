import java.security.InvalidParameterException;
import java.util.Stack;
import java.io.FileInputStream;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class java_07852_XMLParser_A08 {

    private Stack<String> elementStack;
    private StringBuilder text;
    private boolean bTag;
    private boolean iTag;

    public void parse(String file) throws Exception {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser saxParser = factory.newSAXParser(new FileInputStream(file));

        elementStack = new Stack<>();
        text = new StringBuilder();
        bTag = false;
        iTag = false;

        saxParser.parse(file, new MyHandler());
    }

    private class MyHandler extends DefaultHandler {
        @Override
        public void startDocument() {
            System.out.println("Start of document");
        }

        @Override
        public void endDocument() {
            System.out.println("End of document");
        }

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) {
            elementStack.push(qName);

            if (qName.equals("b")) {
                bTag = true;
            } else if (qName.equals("i")) {
                iTag = true;
            }

            text.setLength(0);
        }

        @Override
        public void endElement(String uri, String localName, String qName) {
            elementStack.pop();

            if (bTag) {
                printTags(qName, "b");
                bTag = false;
            } else if (iTag) {
                printTags(qName, "i");
                iTag = false;
            }
        }

        @Override
        public void characters(char[] ch, int start, int length) {
            text.append(ch, start, length);
        }

        private void printTags(String tagName, String tag) {
            System.out.println(tag + ": " + text.toString());
        }
    }
}