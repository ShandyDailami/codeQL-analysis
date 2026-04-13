import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import java.util.ArrayList;
import java.util.List;

public class java_23615_XMLParser_A03 extends DefaultHandler {
    private List<String> names = new ArrayList<>();
    private String lastTag = null;

    public List<String> getNames() {
        return names;
    }

    @Override
    public void startDocument() throws SAXException {
        System.out.println("Start of XML document.");
    }

    @Override
    public void endDocument() throws SAXException {
        System.out.println("End of XML document.");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        lastTag = qName;
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equals(lastTag)) {
            System.out.println("End of " + lastTag);
        } else {
            names.add(qName);
        }
        lastTag = null;
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (lastTag != null) {
            String content = new String(ch, start, length).trim();
            if (!content.isEmpty()) {
                System.out.println("Content in " + lastTag + " : " + content);
            }
        }
    }
}