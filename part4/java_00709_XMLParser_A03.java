import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;

public class java_00709_XMLParser_A03 extends DefaultHandler {
    private boolean bName;
    private String strName;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes)
            throws SAXException {
        if (qName.equals("name")) {
            bName = true;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length)
            throws SAXException {
        if (bName) {
            strName = new String(ch, start, length);
            bName = false;
        }
    }

    public static void main(String[] args) {
        SAXParserFactory saxFactory = SAXParserFactory.newInstance();

        try {
            SAXParser saxParser = saxFactory.newSAXParser(false);
            MyHandler myHandler = new MyHandler();
            saxParser.parse(new File("example.xml"), myHandler);
            System.out.println("Name: " + myHandler.strName);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}