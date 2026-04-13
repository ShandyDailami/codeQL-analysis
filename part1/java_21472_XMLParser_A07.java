import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;

public class java_21472_XMLParser_A07 {
    public static void main(String[] args) {
        try {
            SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
            SAXParser saxParser = saxParserFactory.newSAXParser(null);

            MyHandler myHandler = new MyHandler();
            saxParser.parse(new File("src/sample.xml"), myHandler);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class MyHandler extends DefaultHandler {
    boolean bItem = false;
    boolean bTitle = false;
    boolean bDescription = false;

    String title = "";
    String description = "";

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes)
            throws SAXException {
        if (qName.equals("item")) {
            bItem = true;
        } else if (qName.equals("title")) {
            bTitle = true;
        } else if (qName.equals("description")) {
            bDescription = true;
        }
    }

    @Override
    public void characters(char[] chars, int start, int length)
            throws SAXException {
        if (bItem) {
            title = new String(chars, start, length);
            bItem = false;
        } else if (bTitle) {
            title += new String(chars, start, length);
            bTitle = false;
        } else if (bDescription) {
            description += new String(chars, start, length);
            bDescription = false;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName)
            throws SAXException {
        if (qName.equals("item")) {
            System.out.println("Title: " + title);
            System.out.println("Description: " + description);
        }
    }
}