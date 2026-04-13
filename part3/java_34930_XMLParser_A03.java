import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.XMLReader;
import org.xml.sax.SAXReader;
import java.io.File;
import java.io.IOException;

public class java_34930_XMLParser_A03 {

    public static void main(String[] args) {
        String xmlFile = "src/resources/test.xml";
        parseXmlFile(xmlFile);
    }

    public static void parseXmlFile(String xmlFile) {
        DefaultHandler handler = new DefaultHandler() {
            @Override
            public void startElement(String uri, String localName, String qName, Attributes attributes) {
                System.out.println("Start Element: " + qName);
            }

            @Override
            public void endElement(String uri, String localName, String qName) {
                System.out.println("End Element: " + qName);
            }
        };

        SAXReader reader = new SAXReader();
        try {
            XMLReader xmlReader = reader.getReader(handler);
            xmlReader.parse(new File(xmlFile));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }
}