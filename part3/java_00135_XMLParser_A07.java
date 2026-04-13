import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;

public class java_00135_XMLParser_A07 extends DefaultHandler {
    private boolean bName = false;
    private boolean bAge = false;
    private String name = null;
    private String age = null;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes)
            throws SAXException {
        if (qName.equalsIgnoreCase("name")) {
            bName = true;
        } else if (qName.equalsIgnoreCase("age")) {
            bAge = true;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equalsIgnoreCase("name")) {
            bName = false;
        } else if (qName.equalsIgnoreCase("age")) {
            bAge = false;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (bName) {
            name = new String(ch, start, length);
        } else if (bAge) {
            age = new String(ch, start, length);
        }
    }

    public static void main(String[] args) throws Exception {
        File inputFile = new File("input.xml");
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        SAXParser saxParser = saxParserFactory.newSAXParser();

        MyHandler myHandler = new MyHandler();
        saxParser.parse(inputFile, myHandler);

        System.out.println("User Name: " + myHandler.getName());
        System.out.println("User Age: " + myHandler.getAge());
    }

    public String getName() {
        return name;
    }

    public String getAge() {
        return age;
    }
}