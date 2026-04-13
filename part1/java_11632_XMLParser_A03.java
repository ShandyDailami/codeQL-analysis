import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import java.io.File;
import java.io.IOException;

public class java_11632_XMLParser_A03 {
    public static void main(String[] args) {
        File inputFile = new File("input.xml");
        XMLReader xmlReader;

        try {
            xmlReader = XMLReaderFactory.createXMLReader();
            xmlReader.setContentHandler(new ContentHandler());

            xmlReader.parse(inputFile);
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class ContentHandler implements javax.xml.parsers.ContentHandler {
    private boolean parsingElement;

    public void startDocument() {}
    public void endDocument() {}

    public void startElement(String uri, String localName, String qualifiedName, Attributes attributes) {
        System.out.println("Start Element: " + qualifiedName);
        parsingElement = true;
    }

    public void endElement(String uri, String localName, String qualifiedName) {
        System.out.println("End Element: " + qualifiedName);
        parsingElement = false;
    }

    public void characters(char[] ch, int start, int length) {
        if (parsingElement) {
            System.out.println("Character data: " + new String(ch, start, length));
        }
    }

    public void ignorableWhitespace(char[] ch, int start, int length) {}
    public void processingInstruction(String target, String data) {}
    public void setElementContentHandler(ContentHandler handler) {}
    public void startPrefixMapping(String prefix, String uri) {}
    public void endPrefixMapping(String prefix) {}
    public ContentHandler getElementHandler() { return null; }
}