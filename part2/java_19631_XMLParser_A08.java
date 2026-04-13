import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class java_19631_XMLParser_A08 {
    public static void main(String[] args) {
        File xmlFile = new File("input.xml");

        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();

        try {
            SAXParser saxParser = saxParserFactory.newSAXParser(xmlFile.toURI(), new MyHandler());
            saxParser.parse(xmlFile, new MyHandler());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }

    static class MyHandler extends DefaultHandler {
        private StringBuilder currentValue;

        @Override
        public void startElement(String uri, String localName, String qName, StringBuilder currentValue) {
            this.currentValue = currentValue;
        }

        @Override
        public void characters(char[] ch, int start, int length) {
            currentValue.append(ch, start, length);
        }

        @Override
        public void endElement(String uri, String localName, String qName) {
            System.out.println(currentValue.toString());
            currentValue.setLength(0);
        }
    }
}