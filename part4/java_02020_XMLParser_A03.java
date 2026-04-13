import java.io.FileInputStream;
import java.io.InputStream;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

public class java_02020_XMLParser_A03 {
    public static void main(String[] args) {
        String xmlFile = "example.xml"; // replace this with your xml file
        parseXml(xmlFile);
    }

    public static void parseXml(String xmlFile) {
        try {
            InputStream inputStream = new FileInputStream(xmlFile);
            XMLReader reader = XMLReaderFactory.createXMLReader();

            MyContentHandler contentHandler = new MyContentHandler();
            reader.setContentHandler(contentHandler);

            reader.parse(inputStream);

            inputStream.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class MyContentHandler extends org.xml.sax.helpers.DefaultHandler {

    @Override
    public void startElement(String uri, String localName, String qName, org.xml.sax.Attributes attributes) throws SAXException {
        System.out.println("Start element: " + qName);
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        System.out.println("End element: " + qName);
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        System.out.println("Characters: " + new String(ch, start, length));
    }
}