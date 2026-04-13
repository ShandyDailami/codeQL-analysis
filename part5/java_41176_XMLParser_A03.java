import java.io.File;
import java.io.IOException;
import java.security.Policy;
import java.util.Stack;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.helpers.XMLReaderFactory;

public class java_41176_XMLParser_A03 {

    private DefaultHandler handler = new DefaultHandler() {

        private Stack<String> stack = new Stack<>();

        @Override
        public void startElement(String uri, String localName, String qName,
                String ns) {
            stack.push(qName);
        }

        @Override
        public void endElement(String uri, String localName, String qName) {
            for (int i = 0; i < stack.size() - 1; i++) {
                System.out.print(stack.get(i) + " > ");
            }
            System.out.println(stack.pop());
            stack.clear();
        }
    };

    public void parse(File file) throws ParserConfigurationException, SAXException, IOException {
        XMLReader reader = XMLReaderFactory.createXMLReader();
        reader.setContentHandler(handler);
        reader.setErrorHandler(handler);
        reader.parse(file.getAbsolutePath());
    }

    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
        XMLParser parser = new XMLParser();
        parser.parse(new File("src/main/resources/example.xml"));
    }
}