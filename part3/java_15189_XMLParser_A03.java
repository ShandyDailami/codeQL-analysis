import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.helpers.DefaultHandler;
import java.io.File;
import java.io.IOException;

public class java_15189_XMLParser_A03 extends DefaultHandler {

    private static boolean isInElement = false;
    private static String currentElement = null;
    
    @Override
    public void startElement(String uri, String localName, String qName,
                             org.xml.sax.Attributes attributes) throws SAXException {
        isInElement = true;
        currentElement = qName;
    }

    @Override
    public void endElement(String uri, String localName, String qName)
            throws SAXException {
        isInElement = false;
        currentElement = null;
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (isInElement) {
            String elementContent = new String(ch, start, length).trim();
            if (!elementContent.isEmpty()) {
                // Security sensitive operation related to A03_Injection
                // For example, avoid executing commands with user input.
                // Do not use System.exec() or similar commands.
                System.out.println("Element: " + currentElement + ", Content: " + elementContent);
            }
        }
    }

    public static void main(String[] args) {
        try {
            XMLReader reader = XMLReaderFactory.createXMLReader();
            reader.setContentHandler(new MyXMLParser());
            reader.parse(new File("example.xml"));  // Change to your file
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}