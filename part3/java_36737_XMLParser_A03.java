import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;

public class java_36737_XMLParser_A03 {
    public static void main(String[] args) throws Exception {
        File xmlFile = new File("example.xml");
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        SAXParser saxParser = saxParserFactory.newSAXParser(null);

        MyHandler myHandler = new MyHandler();
        saxParser.parse(xmlFile, myHandler);
    }

    static class MyHandler extends DefaultHandler {
        private StringBuilder sb;

        public java_36737_XMLParser_A03() {
            sb = new StringBuilder();
        }

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            sb.append("Start of ");
            sb.append(qName);
            sb.append("\n");
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            sb.append("End of ");
            sb.append(qName);
            sb.append("\n");
       
            System.out.println(sb.toString());
            sb.setLength(0);  // reset the StringBuilder
        }
    }
}