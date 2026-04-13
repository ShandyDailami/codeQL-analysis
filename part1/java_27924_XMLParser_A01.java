import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.SAXParseException;
import java.util.ArrayList;
import java.util.List;

public class java_27924_XMLParser_A01 extends DefaultHandler {
    private List<String> tags = new ArrayList<>();

    public List<String> getTags() {
        return tags;
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (localName.equals("tag")) {
            tags.add(attributes.getValue("name"));
        }
    }

    public static void main(String[] args) {
        String xml = "<root><tag name='tag1'></tag><tag name='tag2'></tag></root>";
        MinimalistXMLParser parser = new MinimalistXMLParser();
        try {
            parser.parse(new StringReader(xml));
            List<String> tags = parser.getTags();
            for (String tag : tags) {
                System.out.println("Tag: " + tag);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}