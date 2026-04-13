import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.helpers.DefaultHandler;
import java.io.File;
import java.io.IOException;

public class java_35030_XMLParser_A07 extends DefaultHandler {
    @Override
    public void startElement(String uri, String localName, String qName,
                             org.xml.sax.Attributes attributes) throws SAXException {
        System.out.println("Start Element: " + qName);
    }

    @Override
    public void endElement(String uri, String localName, String qName)
            throws SAXException {
        System.out.println("End Element: " + qName);
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        System.out.println("Characters: " + new String(ch, start, length));
    }

    public static void main(String[] args) {
        String xmlFilePath = "path/to/your/xml/file.xml";

        try {
            File xmlFile = new File(xmlFilePath);
            XMLReader xmlReader = XMLReaderFactory.createXMLReader();
            MySAXHandler mySAXHandler = new MySAXHandler();

            xmlReader.setContentHandler(mySAXHandler);
            xmlReader.parse(xmlFile);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}