import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import java.util.ArrayList;
import java.util.List;

public class java_08599_XMLParser_A01 extends DefaultHandler {
    private List<String> namespaces;
    private List<String> tags;
    private StringBuilder currentTag;
    private boolean isInElement;

    public java_08599_XMLParser_A01() {
        this.namespaces = new ArrayList<>();
        this.tags = new ArrayList<>();
        this.currentTag = new StringBuilder();
        this.isInElement = false;
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (this.isInElement) {
            this.currentTag.append("/").append(qName);
        } else {
            this.currentTag.append(qName);
        }

        this.tags.add(this.currentTag.toString());
        this.namespaces.add(uri);
        this.currentTag.setLength(0);
        this.isInElement = true;
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        this.currentTag.append("/").append(qName);
        this.tags.add(this.currentTag.toString());
        this.currentTag.setLength(0);
        this.isInElement = false;
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (this.isInElement) {
            this.currentTag.append(new String(ch, start, length));
        }
    }

    public List<String> getTags() {
        return this.tags;
    }
}

public class Main {
    public static void main(String[] args) throws Exception {
        javax.xml.parsers.SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        SAXParser saxParser = saxParserFactory.newSAXParser(false);

        MyXMLHandler myHandler = new MyXMLHandler();
        saxParser.parse(Main.class.getResourceAsStream("broken_access_control.xml"), myHandler);

        List<String> tags = myHandler.getTags();
        for (String tag : tags) {
            System.out.println(tag);
        }
    }
}