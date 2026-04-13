import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class java_09703_XMLParser_A07 {

    public static void main(String[] args) {
        File xmlFile = new File("input.xml");
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();

        try {
            SAXParser saxParser = saxParserFactory.newSAXParser(null);
            MyHandler myHandler = new MyHandler();
            saxParser.parse(xmlFile, myHandler);
        } catch (SAXException | IOException e) {
            e.printStackTrace();
        }
    }

    static class MyHandler extends DefaultHandler {
        boolean bName = false;
        boolean bAge = false;

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) {
            if (qName.equalsIgnoreCase("person")) {
                System.out.println("Name: " + attributes.getValue("name"));
                System.out.println("Age: " + attributes.getValue("age"));
                bName = true;
                bAge = true;
            } else if (bName && qName.equalsIgnoreCase("name")) {
                System.out.println("Name: " + attributes.getValue(""));
                bName = false;
            } else if (bAge && qName.equalsIgnoreCase("age")) {
                System.out.println("Age: " + attributes.getValue(""));
                bAge = false;
            }
        }
    }
}