import java.io.File;
import java.io.IOException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class java_42022_XMLParser_A07 extends DefaultHandler {

    private boolean isAuthor;

    @Override
    public void startElement(String uri, String localName, String qName,
            String version) throws SAXException {
        if (qName.equals("author")) {
            isAuthor = true;
        }
    }

    @Override
    public void characters(char[] chars, int start, int length)
            throws SAXException {
        if (isAuthor) {
            String value = new String(chars, start, length);
            System.out.println("Author: " + value);
            isAuthor = false;
        }
    }

    public static void main(String[] args) {
        File xmlFile = new File("books.xml");
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        try {
            SAXParser saxParser = saxParserFactory.newSAXParser(null);
            XMLParser handler = new XMLParser();
            saxParser.parse(xmlFile, handler);
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
    }
}