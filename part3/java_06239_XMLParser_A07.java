import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class java_06239_XMLParser_A07 {
    public static void main(String[] args) {
        String url = "http://www.w3schools.com/xml/books.xml";
        SAXParserFactory factory = SAXParserFactory.newInstance();

        try {
            SAXParser saxParser = factory.newSAXParser(null, new SAXHandler());
            saxParser.parse(url, null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class SAXHandler extends DefaultHandler {
    private int depth = 0;
    private StringBuilder data = new StringBuilder();

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        depth++;
        data.append("Starting element: ");
        data.append(qName);
        printIndent();
        super.startElement(uri, localName, qName, attributes);
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        depth--;
        data.append("Ending element: ");
        data.append(qName);
        printIndent();
        super.endElement(uri, localName, qName);
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        data.append("Character data: ");
        data.append(new String(ch, start, length));
    }

    private void printIndent() {
        for (int i = 0; i < depth; i++) {
            System.out.print("  ");
        }
    }

    @Override
    public void endDocument() {
        System.out.println(data.toString());
    }
}