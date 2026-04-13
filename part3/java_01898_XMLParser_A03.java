import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;

public class java_01898_XMLParser_A03 {
    public static void main(String[] args) {
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();

        try {
            SAXParser saxParser = saxParserFactory.newSAXParser(true); // true for returning content
            MyHandler myHandler = new MyHandler();
            saxParser.parse(new File("sample.xml"), myHandler);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class MyHandler extends DefaultHandler {
    private StringBuilder currentElementData;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        currentElementData = new StringBuilder();
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equalsIgnoreCase("student")) {
            System.out.println("Student Name: " + currentElementData.toString());
        } else if (qName.equalsIgnoreCase("course")) {
            System.out.println("Course Name: " + currentElementData.toString());
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        currentElementData.append(new String(ch, start, length));
    }
}