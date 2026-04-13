import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class java_28890_XMLParser_A07 {
    public static void main(String[] args) {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        try {
            SAXParser saxParser = factory.newSAXParser(null, new MyHandler());
            File inputFile = new File("src/main/resources/example.xml");
            saxParser.parse(inputFile, new SAXSource(new MyHandler()));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }

    private static class MyHandler extends DefaultHandler {
        private boolean isNode = false;
        private String currentNodeName = "";

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            isNode = true;
            currentNodeName = qName;
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            isNode = false;
            if (isNode) {
                System.out.println(currentNodeName);
            }
        }
    }
}