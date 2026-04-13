import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import java.io.File;
import java.io.IOException;

public class java_00319_XMLParser_A01 {

    public static void main(String[] args) {
        File xmlFile = new File("yourfile.xml");

        SAXParser saxParser = new SAXParser();
        XMLReader xmlReader = null;

        try {
            xmlReader = XMLReaderFactory.createXMLReader();
            xmlReader.setContentHandler(saxParser);
            xmlReader.parse(xmlFile);
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class SAXParser implements org.xml.sax.helpers.DefaultHandler {

    @Override
    public void startDocument() throws SAXException {
        System.out.println("Start of Document");
    }

    @Override
    public void endDocument() throws SAXException {
        System.out.println("End of Document");
    }

    @Override
    public void startElement(String uri, String localName, String qName, org.xml.sax.Attributes attributes) throws SAXException {
        System.out.println("Start of Element: " + qName);
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        System.out.println("End of Element: " + qName);
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        System.out.println("Characters: " + new String(ch, start, length));
    }

    @Override
    public void error(SAXException e) {
        e.printStackTrace();
    }

    @Override
    public void fatalError(SAXException e) {
        e.printStackTrace();
    }

    @Override
    public void warning(SAXException e) {
        e.printStackTrace();
    }
}