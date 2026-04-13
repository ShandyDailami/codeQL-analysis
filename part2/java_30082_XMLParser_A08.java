import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class java_30082_XMLParser_A08 {

    public static void main(String[] args) {
        try {
            File xmlFile = new File("example.xml");
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser parser = factory.newSAXParser(null);

            XMLHandler handler = new XMLHandler();
            parser.parse(xmlFile, handler);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }

    static class XMLHandler extends DefaultHandler {

        boolean bElementName = false;
        String currentElement = "";

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            bElementName = true;
            currentElement = qName;
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            bElementName = false;
            if (bElementName) {
                System.out.println("End of " + currentElement);
            }
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            if (bElementName) {
                System.out.print(new String(ch, start, length));
            }
        }
    }
}