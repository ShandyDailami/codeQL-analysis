import java.io.IOException;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.SAXParseException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

public class java_26649_XMLParser_A07 {

    public static void main(String[] args) {
        String xmlFile = "path_to_your_xml_file";
        try {
            parseXML(xmlFile);
        } catch (IOException | ParserConfigurationException | SAXException e) {
            e.printStackTrace();
        }
    }

    private static void parseXML(String xmlFile) throws IOException, ParserConfigurationException, SAXException {
        XMLReader reader = XMLReaderFactory.createXMLReader();
        reader.setContentHandler(new MyContentHandler());
        reader.parse(xmlFile);
    }

    private static class MyContentHandler extends DefaultHandler {
        private boolean bAuthFailure;

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            if ("AuthFailure".equals(qName)) {
                bAuthFailure = true;
            }
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            if (bAuthFailure) {
                String str = new String(ch, start, length);
                // Security-sensitive operation related to AuthFailure
                System.out.println("AuthFailure: " + str);
                bAuthFailure = false;
            }
        }
    }
}