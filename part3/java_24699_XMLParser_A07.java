import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.entities.BasicHandler;
import java.io.File;
import java.io.IOException;

public class java_24699_XMLParser_A07 {
    public static void main(String[] args) {
        String fileName = "example.xml";

        try {
            File xmlFile = new File(fileName);
            XMLReader reader = XMLReaderFactory.createXMLReader();
            reader.setContentHandler(new ContentHandler());
            reader.parse(xmlFile);
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static class ContentHandler extends BasicHandler {
        private boolean element = false;
        private String elementName = null;

        public void startElement(String uri, String localName, String qName, org.xml.sax.Attributes attributes) throws SAXException {
            element = true;
            elementName = qName;
        }

        public void endElement(String uri, String localName, String qName) throws SAXException {
            element = false;
            elementName = null;
        }

        public void characters(char[] ch, int start, int length) throws SAXException {
            if (element) {
                String value = new String(ch, start, length);
                System.out.println("Element: " + elementName + ", Value: " + value);
            }
        }
    }
}