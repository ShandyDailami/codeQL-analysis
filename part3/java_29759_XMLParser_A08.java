import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class java_29759_XMLParser_A08 {

    public static void main(String[] args) {
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();

        try {
            SAXParser saxParser = saxParserFactory.newSAXParser(null);

            SAXHandler saxHandler = new SAXHandler();
            saxParser.parse(new File("path_to_your_xml_file"), saxHandler);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }

    static class SAXHandler extends DefaultHandler {

        private boolean bName = false;
        private boolean bAge = false;
        private String currentElement = "";

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            currentElement = qName;

            if (currentElement.equals("person")) {
                bName = true;
                bAge = true;
            } else {
                if (bName) {
                    System.out.print("Name: " + currentElement + " ");
                } else if (bAge) {
                    System.out.println("Age: " + currentElement);
                }
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            if (currentElement.equals("name")) {
                bName = false;
            } else if (currentElement.equals("age")) {
                bAge = false;
            }
            currentElement = "";
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            if (bName) {
                System.out.println("Name: " + new String(ch, start, length));
            } else if (bAge) {
                System.out.println("Age: " + new String(ch, start, length));
            }
        }
    }
}