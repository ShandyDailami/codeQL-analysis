import java.io.File;
import java.io.IOException;
import java.security.KeyStore;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class java_20146_XMLParser_A07 extends DefaultHandler {

    public java_20146_XMLParser_A07() {
        super();
    }

    @Override
    public void startElement(String uri, String localName, String qName,
            String version) throws SAXException {
        System.out.println("Start Element : " + qName);
    }

    @Override
    public void endElement(String uri, String localName, String qName)
            throws SAXException {
        System.out.println("End Element : " + qName);
    }

    @Override
    public void characters(char[] ch, int start, int length)
            throws SAXException {
        System.out.println("Character : "
                + new String(ch, start, length));
    }

    public static void main(String[] args) {
        try {
            File inputFile = new File("input.xml");
            SAXParserFactory spf = SAXParserFactory.newInstance();
            SAXParser saxParser = spf.newSAXParser();

            XMLParser handler = new XMLParser();
            saxParser.parse(inputFile, handler);
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
    }
}