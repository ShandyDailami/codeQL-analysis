import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class java_33720_XMLParser_A07 {

    public static void main(String[] args) {
        String url = "path_to_your_xml_file.xml";  // replace with your xml file
        SAXParserFactory factory = SAXParserFactory.newInstance();

        try {
            SAXParser saxParser = factory.newSAXParser(null, new MyHandler());
            saxParser.parse(new File(url), true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static class MyHandler extends DefaultHandler {

        private StringBuffer buffer = new StringBuffer();
        private String xmlTag;

        @Override
        public void startElement(String namespaceURI, String localName,
                                 String qName, Attributes atts) throws SAXException {
            xmlTag = qName;
            buffer.setLength(0);
        }

        @Override
        public void endElement(String namespaceURI, String localName,
                              String qName) throws SAXException {

            if (qName.equalsIgnoreCase(xmlTag)) {
                System.out.println(buffer.toString());
            } else {
                System.out.println("End of " + xmlTag);
            }
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            buffer.append(ch, start, length);
        }
    }
}