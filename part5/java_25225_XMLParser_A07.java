import java.io.FileInputStream;
import java.io.IOException;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.handler.AbstractHandler;
import org.xml.sax.helpers.DefaultHandler;

public class java_25225_XMLParser_A07 {

    public static void main(String[] args) {
        try {
            XMLReader reader = XMLReaderFactory.createXMLReader();
            MyHandler handler = new MyHandler();
            reader.setContentHandler(handler);
            reader.parse(new FileInputStream("sample.xml"));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }

    static class MyHandler extends DefaultHandler {
        boolean bName = false;
        boolean bAge = false;

        @Override
        public void startElement(String uri, String localName, String qName,
                org.xml.sax.Attributes attributes) throws SAXException {
            if (qName.equalsIgnoreCase("person")) {
                bName = true;
                bAge = true;
            } else if (bName && qName.equalsIgnoreCase("name")) {
                System.out.println("Name: " + attributes.getValue(""));
                bName = false;
            } else if (bAge && qName.equalsIgnoreCase("age")) {
                System.out.println("Age: " + attributes.getValue(""));
                bAge = false;
            }
        }
    }
}