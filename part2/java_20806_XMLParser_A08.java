import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.SAXParseException;
import java.io.File;
import java.io.IOException;

public class java_20806_XMLParser_A08 {

    public static void main(String[] args) {
        File xmlFile = new File("input.xml");
        SAXParser saxParser = new SAXParser();
        DOMParser domParser = new DOMParser();

        try {
            System.out.println("SAX Parser:");
            saxParser.parse(xmlFile, new XmlHandler());
            System.out.println("DOM Parser:");
            domParser.parse(xmlFile, new XmlHandler());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXParseException e) {
            e.printStackTrace();
        }
    }

}

class XmlHandler implements org.xml.sax.helpers.DefaultHandler {

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
    public void error(SAXParseException e) {
        System.out.println("SAX Parse Error: " + e.getMessage());
    }

    @Override
    public void fatalError(SAXParseException e) {
        System.out.println("Fatal SAX Parse Error: " + e.getMessage());
    }

    @Override
    public void warning(SAXParseException e) {
        System.out.println("Warning: " + e.getMessage());
    }
}

class SAXParser {

    public void parse(File xmlFile, org.xml.sax.helpers.DefaultHandler handler) throws IOException, SAXException {
        XMLReader reader = XMLReaderFactory.createXMLReader();
        reader.setContentHandler(handler);
        reader.parse(new SAXSource(new InputSource(new FileInputStream(xmlFile))));
    }
}

class DOMParser {

    public void parse(File xmlFile, org.xml.sax.helpers.DefaultHandler handler) throws IOException, ParsingException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(xmlFile);
        handler.startDocument(null, null, null);
        handler.endDocument(null, null, null);
        // TODO: Handle the document
    }
}