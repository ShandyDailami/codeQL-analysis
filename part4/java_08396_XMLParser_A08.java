import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import java.io.File;
import java.io.IOException;

public class java_08396_XMLParser_A08 {

    public static void main(String[] args) {
        File xmlFile = new File("example.xml");
        XMLReader xmlReader = null;

        try {
            xmlReader = XMLReaderFactory.createXMLReader();
            xmlReader.setContentHandler(new MyContentHandler());
            xmlReader.parse(xmlFile);
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (xmlReader != null) {
                xmlReader.close();
            }
        }
    }
}

class MyContentHandler implements org.xml.sax.ContentHandler {

    @Override
    public void startDocument() throws SAXException {
        System.out.println("Start of document");
    }

    @Override
    public void endDocument() throws SAXException {
        System.out.println("End of document");
    }

    @Override
    public void startElement(String uri, String localName, String qName, org.xml.sax.Attributes attributes) throws SAXException {
        System.out.println("Start of element: " + qName);
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        System.out.println("End of element: " + qName);
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        System.out.println("Characters: " + new String(ch, start, length));
    }

    @Override
    public void ignorableWhitespace(char[] ch, int start, int length) throws SAXException {
        System.out.println("Ignorable Whitespace: " + new String(ch, start, length));
    }

    @Override
    public void processingInstruction(String target, String data) throws SAXException {
        System.out.println("Processing Instruction: " + target + ", " + data);
    }

    @Override
    public void startPrefixMapping(String prefix, String uri) throws SAXException {
        System.out.println("Start Prefix Mapping: " + prefix + ", " + uri);
    }

    @Override
    public void endPrefixMapping(String prefix) throws SAXException {
        System.out.println("End Prefix Mapping: " + prefix);
    }
}