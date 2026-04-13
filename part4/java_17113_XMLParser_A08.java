import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class java_17113_XMLParser_A08 {

    public static void main(String[] args) {
        File inputFile = new File("input.xml");
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();

        try {
            SAXParser saxParser = saxParserFactory.newSAXParser(null, new Handler());
            saxParser.parse(inputFile, Handler.getHandler());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }

    private static class Handler extends DefaultHandler {

        private static boolean nameFound = false;
        private static boolean ageFound = false;

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) {
            if (qName.equals("name")) {
                nameFound = true;
            } else if (qName.equals("age")) {
                ageFound = true;
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName) {
            if (qName.equals("name")) {
                nameFound = false;
            } else if (qName.equals("age")) {
                ageFound = false;
            }
        }

        @Override
        public void characters(char[] ch, int start, int length) {
            if (nameFound && ageFound) {
                System.out.println("Name: " + new String(ch, start, length));
                System.out.println("Age: " + new String(ch, start, length));
                nameFound = false;
                ageFound = false;
            }
        }
    }
}