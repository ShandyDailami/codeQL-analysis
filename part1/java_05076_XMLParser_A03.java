import java.io.File;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

public class java_05076_XMLParser_A03 {
    public static void main(String[] args) {
        try {
            File xmlFile = new File("input.xml");
            XMLReader xmlReader = XMLReaderFactory.createXMLReader();
            xmlReader.setFeature("http://xml.org/sax/features/namespaces", true);

            SAXParserHandler saxParserHandler = new SAXParserHandler();
            xmlReader.setContentHandler(saxParserHandler);

            xmlReader.parse(new java.io.FileInputStream(xmlFile));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class SAXParserHandler implements org.xml.sax.ContentHandler {
    private boolean bName;
    private String sName;

    public java_05076_XMLParser_A03() {
        bName = false;
    }

    public void startElement(String uri, String localName, String qName, org.xml.sax.Attributes attributes) throws SAXException {
        if (qName.equals("name")) {
            bName = true;
            sName = "";
        }
    }

    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (bName && qName.equals("name")) {
            System.out.println("Name: " + sName);
            bName = false;
        }
    }

    public void characters(char[] ch, int start, int length) throws SAXException {
        if (bName) {
            sName = new String(ch, start, length);
        }
    }
}