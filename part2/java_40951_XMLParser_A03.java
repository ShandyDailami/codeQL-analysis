// Start of XMLParser
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.SAXParseException;

public class java_40951_XMLParser_A03 extends DefaultHandler {
    private String thisElement = "";
    private String elementContent = "";

    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        thisElement = qName;
        elementContent = "";
    }

    public void endElement(String uri, String localName, String qName) throws SAXException {
        // A03_Injection: Use of a StringBuilder to prevent buffer overflows
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<").append(thisElement).append(">").append(elementContent).append("</").append(thisElement).append(">");
        System.out.println(stringBuilder.toString());
    }

    public void characters(char[] ch, int start, int length) throws SAXException {
        elementContent = new String(ch, start, length);
    }

    public void error(SAXParseException e) throws SAXException {
        System.out.println("Error: " + e.getMessage());
    }

    public void fatalError(SAXParseException e) throws SAXException {
        System.out.println("Fatal Error: " + e.getMessage());
    }

    public void warning(SAXParseException e) throws SAXException {
        System.out.println("Warning: " + e.getMessage());
    }
}
// End of XMLParser