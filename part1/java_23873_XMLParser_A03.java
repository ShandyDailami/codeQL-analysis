import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.XMLReader;
import org.xml.sax.XMLReaderFactory;

public class java_23873_XMLParser_A03 {

    public static void main(String[] args) {
        String xmlFilePath = "path_to_your_xml_file";
        parseXML(xmlFilePath);
    }

    private static void parseXML(String xmlFilePath) {
        try {
            InputStream inputStream = new FileInputStream(xmlFilePath);
            XMLReader reader = XMLReaderFactory.createXMLReader();
            reader.setContentHandler(new SAXHandler());
            reader.parse(new InputStreamReader(inputStream, "UTF-8"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static class SAXHandler extends DefaultHandler {
        @Override
        public void startElement(String uri, String localName, String qName, java.util.Properties properties) throws SAXException {
            System.out.println("Start Element: " + qName);
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            System.out.println("End Element: " + qName);
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            String content = new String(ch, start, length);
            System.out.println("Content: " + content);
        }
    }
}