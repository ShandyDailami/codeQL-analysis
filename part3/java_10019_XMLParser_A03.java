import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.enters.DOMSource;
import org.w3c.dom.Document;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import java.io.File;
import java.io.IOException;

public class java_10019_XMLParser_A03 {

    public static void main(String[] args) {
        String xmlFile = "sample.xml";  // replace with your own XML file
        parseXMLFile(xmlFile);
    }

    public static void parseXMLFile(String fileName) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        Document doc = null;
        try {
            doc = builder.parse(new File(fileName));
        } catch (SAXException | IOException e) {
            e.printStackTrace();
            return;
        }

        XMLReader reader = XMLReaderFactory.createXMLReader();
        MyContentHandler handler = new MyContentHandler();
        reader.setContentHandler(handler);
        reader.parse(new File(fileName));

        System.out.println(handler.getContent());
    }
}

class MyContentHandler implements org.xml.sax.ContentHandler {

    private StringBuilder content;

    public java_10019_XMLParser_A03() {
        content = new StringBuilder();
    }

    @Override
    public void startDocument() {
        // Nothing to do here
    }

    @Override
    public void endDocument() {
        // Nothing to do here
    }

    @Override
    public void startElement(String uri, String localName, String qName,
                             org.xml.sax.Attributes attributes) {
        // Nothing to do here
    }

    @Override
    public void endElement(String uri, String localName, String qName) {
        // Nothing to do here
    }

    @Override
    public void characters(char[] ch, int start, int length) {
        content.append(new String(ch, start, length));
    }

    public String getContent() {
        return content.toString();
    }
}