import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class java_08202_XMLParser_A07 {

    public static void main(String[] args) {
        SAXParserFactory factory = SAXParserFactory.newInstance();

        try {
            SAXParser saxParser = factory.newSAXParser(null, new SAXHandler());
            saxParser.parse(new File("input.xml"), null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class SAXHandler extends DefaultHandler {

    private StringBuilder data = new StringBuilder();
    private String currentElement = "";

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) {
        currentElement = qName;
        data.setLength(0);
    }

    @Override
    public void endElement(String uri, String localName, String qName) {
        if (currentElement.equals("node")) {
            System.out.println("Data: " + data.toString());
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) {
        data.append(ch, start, length);
    }
}