import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class java_04435_XMLParser_A03 {

    public static void main(String[] args) {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser(null, new SAXHandler());
        try {
            File file = new File("src/main/resources/data.xml");
            parser.parse(new FileInputStream(file), null);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }

    public static class SAXHandler extends DefaultHandler {
        private String lastElement;
        private String lastValue;

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            lastElement = qName;
            lastValue = "";
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            lastValue = new String(ch, start, length);
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            if (lastElement != null && lastElement.equals(qName)) {
                System.out.println("Element: " + lastElement + ", Value: " + lastValue);
            }
        }
    }
}