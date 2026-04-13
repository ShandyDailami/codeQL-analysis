import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.XMLReader;
import org.xml.sax.SAXReader;
import java.io.File;
import java.io.IOException;

public class java_33827_XMLParser_A08 {

    public static class MyHandler extends DefaultHandler {
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            System.out.println("Element: " + qName);
        }
    }

    public static void main(String[] args) {
        String xmlFile = "sample.xml";  // replace with your xml file
        File file = new File(xmlFile);
        SAXReader reader = new SAXReader();

        try {
            XMLReader xmlReader = reader.getReader(file);
            MyHandler handler = new MyHandler();
            xmlReader.setContentHandler(handler);
            xmlReader.parse(file);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}