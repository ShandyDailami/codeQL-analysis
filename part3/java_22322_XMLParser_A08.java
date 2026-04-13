import javax.xml.parsers.*;
import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;

public class java_22322_XMLParser_A08 extends DefaultHandler {

    private String filename;

    public java_22322_XMLParser_A08(String filename) {
        this.filename = filename;
    }

    public void parse() {
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser(new XMLReader(new StringSource(new String(org.apache.commons.io.FileUtils.readFileToString(new java.io.File(filename))))));
            saxParser.setContentHandler(this);
            saxParser.parse();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void startDocument() {
        System.out.println("Start of document");
    }

    public void endDocument() {
        System.out.println("End of document");
    }

    public void startElement(String namespaceURI, String localName, String qualifiedName, Attributes atts) {
        System.out.println("Start of element: " + qualifiedName);
    }

    public void endElement(String namespaceURI, String localName, String qualifiedName) {
        System.out.println("End of element: " + qualifiedName);
    }

    public void characters(char[] ch, int start, int length) {
        System.out.println("Characters: " + new String(ch, start, length));
    }

    public static void main(String[] args) {
        new XmlParser("example.xml").parse();
    }
}