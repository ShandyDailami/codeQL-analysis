import java.util.Stack;
import java.io.File;
import java.io.IOException;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;
import org.xml.sax.SAXReader;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

public class java_27692_XMLParser_A01 {
    private Stack<String> stack = new Stack<>();

    public void parse(String file) throws ParserConfigurationException, SAXException, IOException {
        SAXReader reader = new SAXReader();
        reader.setContentHandler(new DefaultHandler() {
            @Override
            public void startElement(String uri, String localName, String qName, Attributes attributes) {
                System.out.println("Start Element: " + qName);
                stack.push(qName);
            }

            @Override
            public void endElement(String uri, String localName, String qName) {
                System.out.println("End Element: " + qName);
                stack.pop();
            }

            @Override
            public void characters(char[] ch, int start, int length) {
                String str = new String(ch, start, length).trim();
                if (!str.isEmpty()) {
                    String tag = stack.peek();
                    System.out.println("Character Data in Tag: " + tag + " : " + str);
                }
            }
        });
        reader.parse(new File(file));
    }

    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
        XmlParser parser = new XmlParser();
        parser.parse("test.xml");
    }
}