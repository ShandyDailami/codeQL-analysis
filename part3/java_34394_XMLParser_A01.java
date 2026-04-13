import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.SAXParseException;
import java.util.ArrayList;
import java.util.List;

public class java_34394_XMLParser_A01 extends DefaultHandler {

    private List<String> tags = new ArrayList<>();

    public void startDocument() {
        System.out.println("Start of document");
    }

    public void endDocument() {
        System.out.println("End of document");
    }

    public void startElement(String uri, String localName, String qName, Attributes attributes) {
        System.out.println("Start element: " + qName);
        tags.add(qName);
    }

    public void endElement(String uri, String localName, String qName) {
        System.out.println("End element: " + qName);
        tags.remove(qName);
    }

    public void characters(char[] ch, int start, int length) {
        String content = new String(ch, start, length).trim();
        if (!content.isEmpty()) {
            String tag = tags.get(tags.size() - 1);
            System.out.println("Content in " + tag + ": " + content);
        }
    }

    public void error(SAXParseException e) {
        System.out.println("Error: " + e.getMessage());
    }

    public void fatalError(SAXParseException e) {
        System.out.println("Fatal error: " + e.getMessage());
    }

    public static void main(String[] args) {
        MyXMLParser parser = new MyXMLParser();
        try {
            parser.parse(Class.forName("org.xml.sax.SAXParser").getMethod("parse", String.class).invoke(null, Class.forName("org.xml.sax.SAXParser").getMethod("newInstance").invoke(null)));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}