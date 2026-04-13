import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class java_06208_XMLParser_A08 extends DefaultHandler {

    private String lastElement;
    private boolean isInElement;

    public void startDocument() {
        System.out.println("Start of document");
    }

    public void endDocument() {
        System.out.println("End of document");
    }

    public void startElement(String uri, String localName, String qualifiedName, Attributes attributes) {
        System.out.println("Start element: " + qualifiedName);
        lastElement = qualifiedName;
        isInElement = true;
    }

    public void endElement(String uri, String localName, String qualifiedName) {
        System.out.println("End element: " + qualifiedName);
        lastElement = "";
        isInElement = false;
    }

    public void characters(char[] ch, int start, int length) {
        if (isInElement) {
            System.out.println("Character data: " + new String(ch, start, length));
        }
    }

    public void fatalError(SAXException e) {
        System.out.println("Fatal Error: " + e.getMessage());
    }

    public void warning(SAXWarning warning) {
        System.out.println("Warning: " + warning.getMessage());
    }
}