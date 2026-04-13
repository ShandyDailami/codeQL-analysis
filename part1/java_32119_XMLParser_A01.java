import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class java_32119_XMLParser_A01 {

    public static void main(String[] args) {
        String filePath = "path_to_your_xml_file.xml"; // replace with your actual file path
        parseXmlFile(filePath);
    }

    private static void parseXmlFile(String filePath) {
        SAXParserFactory factory = SAXParserFactory.newInstance();

        try {
            SAXParser parser = factory.newSAXParser(null, new MyHandler());
            parser.parse(new File(filePath));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }

    private static class MyHandler extends DefaultHandler {

        private boolean isItem = false;
        private String itemContent = null;

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes)
                throws SAXException {
            if (qName.equalsIgnoreCase("item")) {
                isItem = true;
                itemContent = "";
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            if (qName.equalsIgnoreCase("item")) {
                isItem = false;
                System.out.println("Item: " + itemContent);
            }
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            if (isItem) {
                itemContent += new String(ch, start, length);
            }
        }

    }
}