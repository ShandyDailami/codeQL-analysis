import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.XMLReader;
import org.xml.sax.SAXReader;
import java.io.File;
import java.io.IOException;

public class java_40759_XMLParser_A01 {
    public static void main(String[] args) {
        try {
            File file = new File("example.xml");
            SAXReader reader = new SAXReader();
            XMLHandler handler = new XMLHandler();

            XMLReader xmlReader = reader.getXMLReader(handler);
            xmlReader.parse(file);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }
}

class XMLHandler extends DefaultHandler {
    private boolean bTag = false;
    private String currentElement = "";

    @Override
    public void startElement(String uri, String localName, String qName,
                             org.xml.sax.Attributes attributes) throws SAXException {
        bTag = true;
        currentElement = qName;
    }

    @Override
    public void endElement(String uri, String localName, String qName)
            throws SAXException {
        bTag = false;
        currentElement = "";
    }

    @Override
    public void characters(char[] ch, int start, int length)
            throws SAXException {
        if (bTag) {
            System.out.println(currentElement + " : " + new String(ch, start, length));
        }
    }
}