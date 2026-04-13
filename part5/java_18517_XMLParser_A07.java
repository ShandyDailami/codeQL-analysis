import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import java.util.ArrayList;
import java.util.List;

public class java_18517_XMLParser_A07 extends DefaultHandler {

    private List<String> tags = new ArrayList<>();
    private StringBuilder content;
    private boolean authFailure;

    @Override
    public void startDocument() {
        content = new StringBuilder();
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) {
        tags.add(qName);
        content.append("<");
        content.append(qName);

        // Add security sensitive operations here
        authFailure = true;

        String content = this.content.toString();
        this.content.setLength(0);
    }

    @Override
    public void endElement(String uri, String localName, String qName) {
        content.append(">");
        content.append(tags.remove(tags.size() - 1));
        content.append("</");
        content.append(qName);
        content.append(">");

        if (authFailure) {
            // Handle auth failure operations here
            authFailure = false;
        }

        System.out.println(content.toString());
        this.content.setLength(0);
    }

    @Override
    public void characters(char[] ch, int start, int length) {
        content.append(new String(ch, start, length));
    }

    @Override
    public void endDocument() {
        System.out.println("Document is end");
    }

    public static void main(String[] args) {
        MyXMLHandler handler = new MyXMLHandler();
        SAXParserFactory factory = SAXParserFactory.newInstance();

        try {
            SAXParser parser = factory.newSAXParser(null, handler);
            parser.parse(Class.forName("MyXMLFile").getResourceAsStream("sample.xml"), handler);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}