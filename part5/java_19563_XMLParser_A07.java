import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import java.util.ArrayList;
import java.util.List;

public class java_19563_XMLParser_A07 extends DefaultHandler {
    private List<String> tags = new ArrayList<>();
    private StringBuffer buffer = new StringBuffer();

    public List<String> getTags() {
        return tags;
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        buffer.setLength(0);
        tags.add(qName);
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        tags.add(qName);
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        buffer.append(ch, start, length);
    }

    public static void main(String[] args) throws Exception {
        MyXMLParser(args[0]);
    }

    public static void MyXMLParser(String fileName) throws Exception {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser(new Class[] { InputSource.class });

        MyXMLHandler handler = new MyXMLHandler();
        InputSource source = new InputSource(new FileReader(fileName));
        parser.parse(source, handler);

        List<String> tags = handler.getTags();
        for (String tag : tags) {
            System.out.println(tag);
        }
    }
}