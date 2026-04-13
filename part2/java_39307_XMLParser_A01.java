import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;

public class java_39307_XMLParser_A01 extends DefaultHandler {

    private boolean isTitle = false;
    private boolean isLink = false;
    private StringBuilder content;

    public void startDocument() {
        content = new StringBuilder();
    }

    public void startElement(String uri, String localName, String qName, Attributes attributes) {
        if (qName.equalsIgnoreCase("title")) {
            isTitle = true;
        }
        if (qName.equalsIgnoreCase("link")) {
            isLink = true;
        }
        content.append("<").append(qName);
        for (int i = 0; i < attributes.getLength(); i++) {
            content.append(" ").append(attributes.getQName(i)).append("=").append("\"").append(attributes.getValue(i)).append("\"");
        }
        content.append(">");
    }

    public void endElement(String uri, String localName, String qName) {
        content.append("</").append(qName).append(">");
        if (qName.equalsIgnoreCase("title")) {
            isTitle = false;
        }
        if (qName.equalsIgnoreCase("link")) {
            isLink = false;
        }
    }

    public void endDocument() {
        System.out.println(content.toString());
    }

    public static void main(String[] args) {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        try {
            SAXParser parser = factory.newSAXParser();
            parser.parse(new File("sample.xml"), new MyXMLHandler());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}