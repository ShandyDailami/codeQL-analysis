import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class java_23940_XMLParser_A08 {

    public static void main(String[] args) {
        String xmlFile = "sample.xml";  // your XML file path
        parseXmlFile(xmlFile);
    }

    private static void parseXmlFile(String file) {
        SAXParserFactory factory = SAXParserFactory.newInstance();

        try {
            SAXParser parser = factory.newSAXParser(null, new MyHandler());
            parser.parse(new File(file));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }

    private static class MyHandler extends DefaultHandler {
        private StringBuffer buffer = new StringBuffer();
        private boolean element = false;

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) {
            element = true;
            buffer.setLength(0);
            buffer.append(qName);
        }

        @Override
        public void characters(char[] ch, int start, int length) {
            if (element) {
                buffer.append(ch, start, length);
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName) {
            element = false;
            System.out.println(buffer.toString());
        }
    }
}