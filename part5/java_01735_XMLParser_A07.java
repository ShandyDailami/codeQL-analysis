import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class java_01735_XMLParser_A07 extends DefaultHandler {
    private boolean isUserName = false;
    private boolean isPassword = false;
    private String userName = null;
    private String password = null;

    public static void main(String[] args) {
        String xmlFile = "path/to/your/xml/file.xml";
        SAXParserFactory factory = SAXParserFactory.newInstance();
        try {
            SAXParser parser = factory.newSAXParser();
            SecureXmlParser handler = new SecureXmlParser();
            parser.parse(new File(xmlFile), handler);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) {
        if (qName.equalsIgnoreCase("user")) {
            isUserName = true;
        } else if (qName.equalsIgnoreCase("password")) {
            isPassword = true;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) {
        if (qName.equalsIgnoreCase("user")) {
            isUserName = false;
        } else if (qName.equalsIgnoreCase("password")) {
            isPassword = false;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) {
        if (isUserName) {
            userName = new String(ch, start, length);
        } else if (isPassword) {
            password = new String(ch, start, length);
        }
    }
}