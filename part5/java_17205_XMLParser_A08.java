import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import java.io.File;
import java.io.IOException;

public class java_17205_XMLParser_A08 {

    public static void main(String[] args) {
        File xmlFile = new File("sample.xml");
        SAXParser saxParser = new SAXParser();

        try {
            XMLReader xmlReader = XMLReaderFactory.createXMLReader();
            saxParser.parse(xmlFile, xmlReader);

            System.out.println("Element Names: ");
            for (String name : saxParser.getNames()) {
                System.out.println(name);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }
}

class SAXParser {
    private String[] elementNames;

    public void parse(File xmlFile, XMLReader xmlReader) throws IOException, SAXException {
        elementNames = new String[100]; // Assuming we only need the first 100 elements
        xmlReader.setContentHandler(new ContentHandler(elementNames));
        xmlReader.parse(new InputSource(new FileInputStream(xmlFile)));
    }

    public String[] getNames() {
        return elementNames;
    }
}

class ContentHandler implements ContentHandlerInterface {
    private String[] elementNames;
    private int elementCount;

    public java_17205_XMLParser_A08(String[] elementNames) {
        this.elementNames = elementNames;
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (elementCount < elementNames.length) {
            elementNames[elementCount] = localName;
            elementCount++;
        } else {
            throw new SAXException("Too many elements");
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        // Ignore end elements
    }

    @Override
    public void characters(String chars, int start, int length) throws SAXException {
        // Ignore characters
    }
}