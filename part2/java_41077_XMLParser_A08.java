import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;

public class java_41077_XMLParser_A08 {

    public static void parse(String fileName) {
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();

        try {
            SAXParser saxParser = saxParserFactory.newSAXParser();

            MyHandler myHandler = new MyHandler();
            saxParser.parse(new File(fileName), myHandler);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static class MyHandler extends DefaultHandler {

        boolean bNodeFound = false;
        String thisNodeValue = null;

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes)
                throws SAXException {
            bNodeFound = true;
            thisNodeValue = "";
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            bNodeFound = false;

            if(thisNodeValue != null){
                System.out.println("Node Value: " + thisNodeValue);
            }
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            if (bNodeFound){
                thisNodeValue = new String(ch, start, length);
            }
        }
    }

    public static void main(String[] args) {
        parse("sample.xml");
    }
}