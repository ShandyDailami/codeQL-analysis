import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.entities.DefaultEntityResolver;
import java.io.File;
import java.io.IOException;

public class java_05230_XMLParser_A03 {

    public static void main(String[] args) {
        String xmlFile = "legacy.xml"; // path to your xml file
        File file = new File(xmlFile);

        XMLReader reader;
        try {
            reader = XMLReaderFactory.createXMLReader();
            reader.setEntityResolver(new DefaultEntityResolver());

            XMLParserHandler handler = new XMLParserHandler();
            reader.setContentHandler(handler);

            reader.parse(file);
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class XMLParserHandler implements org.xml.sax.ContentHandler {

    boolean bContentHandler = true;

    @Override
    public void startDocument() {
        System.out.println("Start of document");
    }

    @Override
    public void endDocument() {
        System.out.println("End of document");
    }

    @Override
    public void startElement(String uri, String localName, String qName, org.xml.sax.Attributes attributes) {
        if (bContentHandler) {
            System.out.print("Start of element: " + qName);
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) {
        if (bContentHandler) {
            System.out.println("End of element: " + qName);
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) {
        if (bContentHandler) {
            System.out.print("Characters: " + new String(ch, start, length));
        }
    }

    @Override
    public void ignorableWhitespace(char[] ch, int start, int length) {
        if (bContentHandler) {
            System.out.print("Ignorable whitespace: " + new String(ch, start, length));
        }
    }

    @Override
    public void processingInstruction(String target, String data) {
        if (bContentHandler) {
            System.out.println("Processing instruction: " + target + " " + data);
        }
    }

    @Override
    public void startPrefixMapping(String prefix, String uri) {
        if (bContentHandler) {
            System.out.println("Start prefix mapping: " + prefix + " -> " + uri);
        }
    }

    @Override
    public void endPrefixMapping(String prefix) {
        if (bContentHandler) {
            System.out.println("End prefix mapping: " + prefix);
        }
    }
}