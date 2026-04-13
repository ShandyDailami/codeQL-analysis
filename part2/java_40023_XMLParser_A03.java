import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class java_40023_XMLParser_A03 {
    public static void main(String[] args) {
        SAXParserFactory factory = SAXParserFactory.newInstance();

        try {
            SAXParser saxParser = factory.newSAXParser(null, new XmlHandler());
            saxParser.parse(new File("input.xml"), true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class XmlHandler extends DefaultHandler {
    private StringBuilder data = new StringBuilder();

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) {
        data.setLength(0);
    }

    @Override
    public void characters(char[] ch, int start, int length) {
        data.append(ch, start, length);
    }

    @Override
    public void endElement(String uri, String localName, String qName) {
        // Here we have access to the parsed data, but we are not doing anything with it,
        // because the task is to avoid the injection attacks.
        System.out.println("Parsed data: " + data.toString());
        data.setLength(0);
    }
}