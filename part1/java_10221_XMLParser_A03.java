import java.util.List;
import java.util.stream.Collectors;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.parser.SAXParser;
import org.xml.sax.parser.SAXParserFactory;

public class java_10221_XMLParser_A03 extends DefaultHandler {
    private StringBuilder content;
    private boolean isElement = false;
    private boolean isItem = false;

    public static void main(String[] args) {
        String xml = "<items>\n" +
                "    <item>\n" +
                "        <name>Apple</name>\n" +
                "        <price>10</price>\n" +
                "    </item>\n" +
                "    <item>\n" +
                "        <name>Banana</name>\n" +
                "        <price>5</price>\n" +
                "    </item>\n" +
                "</items>";

        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        try {
            SAXParser saxParser = saxParserFactory.newSAXParser();
            MyXMLParser myXMLParser = new MyXMLParser();
            saxParser.parse(new StringReader(xml), myXMLParser);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) {
        content = new StringBuilder();
        if (qName.equals("item")) {
            isItem = true;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) {
        if (isItem) {
            content.append(new String(ch, start, length));
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equals("name")) {
            isElement = false;
            System.out.println("Name: " + content.toString());
        } else if (qName.equals("price")) {
            isElement = false;
            System.out.println("Price: " + content.toString());
        }
    }
}