import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.parser.SAXParser;
import org.xml.sax.parser.SAXParserFactory;

import java.io.File;
import java.io.IOException;

public class java_04222_XMLParser_A03 extends DefaultHandler {

    private String currentElement;

    public static void main(String[] args) {
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();

        try {
            SAXParser saxParser = saxParserFactory.newSAXParser(null);
            MySAXHandler mySAXHandler = new MySAXHandler();
            saxParser.parse(new File("input.xml"), mySAXHandler);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) {
        currentElement = qName;
    }

    @Override
    public void endElement(String uri, String localName, String qName) {
        currentElement = "";
    }

    @Override
    public void characters(char[] ch, int start, int length) {
        if (currentElement != null && currentElement.equals("name")) {
            System.out.println(new String(ch, start, length));
        }
    }
}