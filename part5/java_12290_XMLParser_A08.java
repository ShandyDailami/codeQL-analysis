import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.SAXParseException;
import java.util.ArrayList;
import java.util.List;

public class java_12290_XMLParser_A08 extends DefaultHandler {
    private boolean bTag = false;
    private String currElement = "";
    private List<String> tags = new ArrayList<>();

    @Override
    public void startDocument() throws SAXParseException {
        System.out.println("Start of document");
    }

    @Override
    public void endDocument() throws SAXParseException {
        System.out.println("End of document");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        System.out.println("Start of element " + qName);
        currElement = qName;
        bTag = true;
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        System.out.println("End of element " + qName);
        bTag = false;
        currElement = "";
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (bTag) {
            String content = new String(ch, start, length);
            System.out.println("Content inside element " + currElement + " : " + content);
        }
    }
}