import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.enters.XMLReader;
import java.io.File;
import java.io.IOException;

public class java_24040_XMLParser_A03 {
    public static void main(String[] args) {
        File inputFile = new File("input.xml");
        XMLReader reader = null;

        try {
            reader = XMLReaderFactory.createXMLReader();
            reader.setContentHandler(new ContentHandler());

            reader.parse(inputFile);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                reader.close();
            }
        }
    }
}

class ContentHandler implements org.xml.sax.ContentHandler {
    public void startDocument() {
        System.out.println("Start of Document");
    }

    public void endDocument() {
        System.out.println("End of Document");
    }

    public void startElement(String uri, String localName, String qName, Attributes attributes) {
        System.out.println("Start of Element: " + qName);
    }

    public void endElement(String uri, String localName, String qName) {
        System.out.println("End of Element: " + qName);
    }

    public void characters(String chars, int start, int length) {
        System.out.println("Characters: " + chars);
    }

    public void ignorableWhitespace(String text) {
        System.out.println("Ignorable Whitespace: " + text);
    }

    public void processingInstruction(String target, String data) {
        System.out.println("Processing Instruction: " + target + ", " + data);
    }

    public void setDocumentLocator(Locator locator) {
        // Not used in this example
    }
}