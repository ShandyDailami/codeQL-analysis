import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.parser.SAXParser;
import org.xml.sax.parser.XMLParser;
import org.xml.sax.parser.XMLReader;
import org.xml.sax.parser.XMLScanner;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class java_13589_XMLParser_A03 {

    private static class MyHandler extends DefaultHandler {

        private Map<String, String> data = new HashMap<>();
        private String curElement = "";

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            curElement = qName;
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            if (!qName.equals(curElement)) {
                return;
            }
            data.put(curElement, "PROTECTED");
            curElement = "";
        }
    }

    public static void main(String[] args) {
        try {
            SAXParser saxParser = SAXParserFactory.newInstance().newSAXParser(new InputSource(new StringReader("<doc>Protected Data</doc>")));
            MyHandler handler = new MyHandler();
            saxParser.parse(new InputSource(new File("input.xml")), handler);
            for (Map.Entry<String, String> entry : handler.data.entrySet()) {
                System.out.println(entry.getKey() + " : " + entry.getValue());
            }
        } catch (ParserConfigurationException | IOException | SAXException e) {
            e.printStackTrace();
        }
    }
}