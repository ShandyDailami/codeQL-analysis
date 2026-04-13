import java.io.File;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

public class java_21718_XMLParser_A08 {
    public static void main(String[] args) {
        try {
            File xmlFile = new File("example.xml");
            XMLReader xmlReader = XMLReaderFactory.createXMLReader();

            xmlReader.setContentHandler(new XmlContentHandler());
            xmlReader.parse(xmlFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class XmlContentHandler extends DefaultHandler {
    private boolean inElement = false;
    private String currentElement = null;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes)
            throws SAXException {
        inElement = true;
        currentElement = qName;
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        inElement = false;
        currentElement = null;
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (inElement) {
            String elementContent = new String(ch, start, length);
            System.out.println(currentElement + ": " + elementContent);
        }
    }
}