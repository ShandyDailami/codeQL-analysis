import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;

public class java_22262_XMLParser_A01 extends DefaultHandler {

    private String lastElementName = "";

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        lastElementName = qName;
        System.out.println("Start element: " + qName);
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        lastElementName = "";
        System.out.println("End element: " + qName);
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (lastElementName.equals("")) {
            System.out.println("Characters: " + new String(ch, start, length));
        }
    }
}

public class Main {

    public static void main(String[] args) {
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        try {
            SAXParser saxParser = saxParserFactory.newSAXParser(true);
            MySAXHandler mySAXHandler = new MySAXHandler();
            saxParser.parse(new File("input.xml"), mySAXHandler);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}