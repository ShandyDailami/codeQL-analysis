import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import java.util.ArrayList;
import java.util.List;

public class java_17484_XMLParser_A08 extends DefaultHandler {
    private boolean isTitle = false;
    private boolean isLink = false;
    private String currentElement;
    private List<String> links = new ArrayList<>();

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes)
            throws SAXException {
        currentElement = qName;
        if(qName.equalsIgnoreCase("title")) {
            isTitle = true;
        } else if(qName.equalsIgnoreCase("link")) {
            isLink = true;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if(qName.equalsIgnoreCase("title")) {
            isTitle = false;
        } else if(qName.equalsIgnoreCase("link")) {
            isLink = false;
        }
        if(isTitle && isLink) {
            links.add(currentElement);
        }
    }

    public static void main(String[] args) {
        SAXParser saxParser = new SAXParser();
        String xml = "<bookstore>\n" +
                "<title>The Great Gatsby</title>\n" +
                "<link>http://www.gatsby.com</link>\n" +
                "<title>Moby Dick</title>\n" +
                "<link>http://mobydick.com</link>\n" +
                "</bookstore>";
        saxParser.parse(xml);
        for(String link : saxParser.getLinks()) {
            System.out.println(link);
        }
    }

    public List<String> getLinks() {
        return links;
    }
}