import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.io.InputStream;

public class java_14025_XMLParser_A08 extends DefaultHandler {

    private StringBuffer buffer;
    private boolean bName;
    private boolean bAuthor;

    public java_14025_XMLParser_A08() {
        buffer = new StringBuffer();
        bName = bAuthor = false;
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName.equalsIgnoreCase("book")) {
            bName = bAuthor = true;
            buffer.setLength(0);
        } else if (bName) {
            buffer.append("Name: ");
            bName = false;
        } else if (bAuthor) {
            buffer.append("Author: ");
            bAuthor = false;
        }
        buffer.append(localName);
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equalsIgnoreCase("book")) {
            System.out.println(buffer.toString());
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (bName || bAuthor) {
            buffer.append(new String(ch, start, length));
        }
    }

    public static void main(String[] args) {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        try {
            SAXParser parser = factory.newSAXParser();
            InputStream is = Class.forName("MyXMLHandler").getResourceAsStream("books.xml");
            parser.parse(is, new MyXMLHandler());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}