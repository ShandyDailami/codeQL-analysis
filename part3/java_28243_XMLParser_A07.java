import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;

public class java_28243_XMLParser_A07 {
    public static void main(String[] args) {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        try {
            SAXParser saxParser = factory.newSAXParser(null, new XMLHandler());
            saxParser.parse(new File("input.xml"), true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class XMLHandler extends DefaultHandler {
    private StringBuilder stringBuilder;
    private boolean isName = false;
    private boolean isEmail = false;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) {
        stringBuilder = new StringBuilder();

        if (qName.equals("name")) {
            isName = true;
        } else if (qName.equals("email")) {
            isEmail = true;
        }
    }

    @Override
    public void characters(char[] chars, int start, int length) {
        if (isName) {
            stringBuilder.append(chars, start, length);
            isName = false;
        } else if (isEmail) {
            stringBuilder.append(chars, start, length);
            isEmail = false;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) {
        if (qName.equals("user")) {
            System.out.println("Name: " + stringBuilder.toString());
        } else if (qName.equals("email")) {
            System.out.println("Email: " + stringBuilder.toString());
        }
    }
}