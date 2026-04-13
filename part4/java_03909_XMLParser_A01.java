import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import java.util.ArrayList;
import java.util.List;

public class java_03909_XMLParser_A01 extends DefaultHandler {

    private String currentElement = "";
    private List<String> listOfStrings = new ArrayList<>();
    private boolean isTitle = false;
    private boolean isLink = false;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName.equalsIgnoreCase("title")) {
            isTitle = true;
        } else if (qName.equalsIgnoreCase("link")) {
            isLink = true;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equalsIgnoreCase("title")) {
            isTitle = false;
        } else if (qName.equalsIgnoreCase("link")) {
            isLink = false;
        }

        if (isTitle) {
            listOfStrings.add(qName);
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (isTitle) {
            listOfStrings.add(new String(ch, start, length));
        }
    }

    public static void main(String[] args) {
        XmlParsingExample handler = new XmlParsingExample();
        try {
            SAXParserFactory saxFactory = SAXParserFactory.newInstance();
            SAXParser saxParser = saxFactory.newSAXParser(true);
            saxParser.parse("src/main/resources/broken-access-control.xml", handler);

            for (String str : handler.listOfStrings) {
                System.out.println(str);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}