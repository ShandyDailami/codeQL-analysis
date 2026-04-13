import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;
import java.io.File;
import java.io.IOException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

public class java_15193_XMLParser_A01 {

    public static void main(String[] args) {

        // Create a DocumentBuilder
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        // Use the builder to build a document
        Document doc = null;
        try {
            doc = builder.parse(new File("sample.xml"));
        } catch (SAXException | IOException e) {
            e.printStackTrace();
        }

        // Print out the content of the document
        printDocument(doc);
    }

    private static void printDocument(Document doc) {
        XMLReader reader = XMLReaderFactory.createXMLReader();
        reader.setContentHandler(new XmlContentHandler());
        reader.parse("sample.xml");
    }

}

class XmlContentHandler implements org.xml.sax.ContentHandler {

    @Override
    public void startDocument() {
        System.out.println("Start of Document");
    }

    @Override
    public void endDocument() {
        System.out.println("End of Document");
    }

    @Override
    public void startElement(String uri, String localName, String qName, org.xml.sax.Attributes attributes) {
        System.out.println("Start of " + qName);
    }

    @Override
    public void endElement(String uri, String localName, String qName) {
        System.out.println("End of " + qName);
    }

    @Override
    public void characters(char[] chars, int start, int length) {
        System.out.println("Characters: " + new String(chars, start, length));
    }

}