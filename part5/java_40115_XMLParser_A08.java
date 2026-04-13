import java.io.File;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.enters.SAXDriver;

public class java_40115_XMLParser_A08 {
    public static void main(String[] args) {
        try {
            File xmlFile = new File("myFile.xml");
            XMLReader xmlReader = XMLReaderFactory.createXMLReader();

            SAXDriver saxDriver = new SAXDriver() {
                public void startElement(String uri, String localName, String qName) throws SAXException {
                    System.out.println("Start Element: " + qName);
                }

                public void endElement(String uri, String localName, String qName) throws SAXException {
                    System.out.println("End Element: " + qName);
                }

                public void characters(char[] ch, int start, int length) throws SAXException {
                    if (length > 0) {
                        String content = new String(ch, start, length);
                        System.out.println("Element Content: " + content);
                    }
                }
            };

            xmlReader.setContentHandler(saxDriver);
            xmlReader.parse(xmlFile);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}